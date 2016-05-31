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
          <div class="ui menu"><a href="#" class="item">登陆</a><a href="#" class="item">注册</a>
            <div class="right item">
              <div class="ui icon input">
                <input type="text" placeholder="搜索电影院或电影"><i class="search icon"></i>
              </div>
            </div>
          </div>
        </nav>
        <div class="content">
          <div class="header">
            <div class="logo">logo</div>
          </div>
          <div class="pay-order-container">
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
          <div class="pay-btn-container"><a href="#">
              <button class="ui primary button purchase-btn">确认无误,去付款</button></a></div>
        </div>
      </div>
      <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
      <script src="../resources/css/lib/semantic/dist/semantic.min.js"></script>
      <script type="text/javascript">
        $(doucment).ready(function() {
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

              var order_html = 
                              '<tr>\
                                <td>'+start_time.getMonth()+'月'+start_time.getDate()+'号 '+start_time.getDay()+' '+start_time.getHours()+':'+start_time.getMinutes()+'</td>\
                                <td>'+movie_name+'</td>\
                                <td>'+cinema_name+'</td>\
                                <td>'+seats_str+'</td>\
                              </tr>';
              $('#order_tbody').html(order_html);

              var order_state = order.state;
              if (order_state == 'success' || order_state == 'fail') {
                $('#timer,.purchase-btn').hide();
              } else {
                var order_creat_time = order.time;
                var remain_time = (new Date()).valueOf()-order_creat_time;
                var minutes = Date(remain_time).getMinutes();
                var seconds = remain_time.getSeconds();
                $('.time-left').html('请在'+minutes+'分钟'+seconds+'秒内支付完成');

                var inteval = window.setInterval(minus_one_seconds, 1000);
             
                function minus_one_seconds() {
                  if (seconds == 0) {
                    if (minutes == 0) {
                      clearInterval(inteval);
                      $('#timer,.purchase-btn').hide();
                      return;
                    } else {
                      seconds == 59;
                      minutes--;
                    }
                  } else {
                    seconds--;
                  }
                  $('.time-left').html('请在'+minutes+'分钟'+seconds+'秒内支付完成');
                }
              }
            }
          });

        })

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