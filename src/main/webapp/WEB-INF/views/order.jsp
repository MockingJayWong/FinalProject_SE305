<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <title>首页</title>
    <link href="../resources/css/lib/semantic/dist/semantic.min.css" rel="stylesheet">
    <link href="../resources/css/pay.css" rel="stylesheet">
  </head>
  <body>
    <div class="whole">
      <div class="ui main container">
        <nav class="navigator">
          <div class="ui menu">
            <a href=".." class="item">首页</a>
            <a id="menu_item_1" href="../account/login" class="item">登陆</a>
            <a id="menu_item_2" href="../account/register" class="item">注册</a>
            <a id="menu_item_3" href="../account/user/orderList" class="item">我的订单</a>
            <div class="right item">
              <div class="ui icon input">
                <input type="text" placeholder="搜索电影院或电影"><i class="search icon"></i>
              </div>
            </div>
          </div>
        </nav>
        <div class="content">
          <div class="header">
            <a href=".."><img src="../resources/images/logo.png" alt="logo" class="logo"/></a>
          </div>
          <div class="pay-order-container">
            <div id="cancel_tip">订单已取消</div>
            <div id="finish_tip">订单已完成</div>
            <div id="timer" class="count-down-container"><i class="smile icon large"></i>
              <div class="tips">
                <div class="time-left">请在15分钟0秒内支付完成</div>
                <div class="otherwise">超时订单会自动取消，如遇支付问题，请拨打电话</div>
              </div>
            </div>
            <table class="order-detail ui celled table">
              <thead>
                <tr>
                  <th>观影时间</th>
                  <th>影片</th>
                  <th>影院</th>
                  <th>座位</th>
                </tr>
              </thead>
              <tbody id="order_tbody">
                <tr>
                  <td>6月8号 周三 0:00</td>
                  <td>美国队长3</td>
                  <td>天河影院</td>
                  <td>1排2座</td>
                </tr>
              </tbody>
            </table>
            <div class="total">
              <div class="label">应付总额: </div>
              <div class="value">
                 
                ￥73
              </div>
            </div>
          </div>
          <div class="pay-btn-container"><a>
              <button class="ui primary button purchase-btn">确认无误,去付款</button></a></div>
        </div>
      </div>
      <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
      <script src="../resources/css/lib/semantic/dist/semantic.min.js"></script>
      <script type="text/javascript">
        $(document).ready(function() {
        	
        	$("#cancel_tip, #finish_tip").hide();
        	
        	function getCookie(name)
          {
              var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
              if(arr=document.cookie.match(reg))
              return unescape(arr[2]);
              else
              return null;
          }
          var username = getCookie('username');
          if (username && username != '""') {
            $('#menu_item_1').attr('href', '../account/user').html('Hello, '+username);
            $('#menu_item_2').attr('href', '../account/logOut').html('退出');
          } else {
              $('#menu_item_3').hide();
          }
        	
       	  // 从url获取orderId
          var url = window.location.href;
          var temp_array =  url.split('/');
          var orderId = temp_array[temp_array.length-1];

          // 获取订单的详细信息
          $.ajax({
            url:'detail',
            data:{orderId:orderId},
            success:function(responseJson) {
              var order = responseJson.data.order;
              var cinema = responseJson.data.cinema;
              var seats = responseJson.data.list;
              var session = responseJson.data.session;

              var start_time = new Date(session.start_time*1000);
              var movie_name = session.movieName;
              var cinema_name = cinema.cinemaName;
              var seats_str = "";
              for (var seatIndex in seats) {
                var seat = seats[seatIndex];
                seats_str += seat[0]+'排'+seat[1]+'座\n';
              }

              var day_map = {
                0:'周日',
                1:'周一',
                2:'周二',
                3:'周三',
                4:'周四',
                5:'周五',
                6:'周六'
              }

              var day = start_time.getDay();
              var order_html = 
                              '<tr>\
                                <td>'+start_time.getMonth()+'月'+start_time.getDate()+'号 '+day_map[day]+' '+start_time.getHours()+':'+start_time.getMinutes()+'</td>\
                                <td>'+movie_name+'</td>\
                                <td>'+cinema_name+'</td>\
                                <td>'+seats_str+'</td>\
                              </tr>';
              $('#order_tbody').html(order_html);

              var order_state = order.state;
              if (order_state == '0') {
                $('#timer,.purchase-btn').hide();
                $('#finish_tip').show();
              } else if (order_state == '2') {
            	  $('#timer,.purchase-btn').hide();
                $('#cancel_tip').show();
              } else {
                var order_create_time = order.time;
                
                var remain_time = 1000*60*15 - ((new Date()).valueOf()-order_create_time);
                if (remain_time < 0) {
                	$('#timer,.purchase-btn').hide();
                	$('#cancel_tip').show();
                } else {
	                var minutes = (new Date(remain_time)).getMinutes();
	                var seconds = (new Date(remain_time)).getSeconds();
	                $('.time-left').html('请在'+minutes+'分钟'+seconds+'秒内支付完成');
	
	                var inteval = window.setInterval(minus_one_seconds, 1000);
	             
	                function minus_one_seconds() {
	                  if (seconds == 0) {
	                    if (minutes == 0) {
	                      clearInterval(inteval);
	                      $('#timer,.purchase-btn').hide();
	                      $('#cancel_tip').show();
	                      return;
	                    } else {
	                      seconds = 59;
	                      minutes--;
	                    }
	                  } else {
	                    seconds--;
	                  }
	                  $('.time-left').html('请在'+minutes+'分钟'+seconds+'秒内支付完成');
	                }
                }
              }
            }
          });
          
          $(".purchase-btn").click(function(){
            $.ajax({
              url:"payOrder",
              data:{orderID:orderId},
              success:function(responseJson) {
            	  status = responseJson.status;
            	  switch(status) {
            	   case "success":
            		   $('#timer,.purchase-btn').hide();
                   $('#finish_tip').show();
                   break;
            	   case "fail":
            		   $('#timer,.purchase-btn').hide();
                   $('#cancel_tip').html("支付过程中出现错误").show();
                   break;
                 default:
                	 break;
            	  }
              },
              error:function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
              }
            });
          });

        });

        function getUrlParam(name){  
          //构造一个含有目标参数的正则表达式对象  
          var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");  
          //匹配目标参数  
          var r = window.location.search.substr(1).match(reg);  
          //返回参数值  
          if (r!=null) return unescape(r[2]);  
          return null;  
        }
      </script>
    </div>
  </body>
</html>