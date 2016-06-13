<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <link href="../../resources/css/lib/semantic/dist/semantic.min.css" rel="stylesheet">
    <link href="../../resources/css/orderList.css" rel="stylesheet">
  </head>
  <body>
    <div class="whole">
      <div class="ui main container">
        <nav class="navigator">
          <div class="ui menu">
            <a href="../.." class="item">首页</a>
            <a id="menu_item_1" href="../login" class="item">登陆</a>
            <a id="menu_item_2" href="../register" class="item">注册</a>
            <a id="menu_item_3" href="#" class="item">我的订单</a>
            <div class="right item">
              <div class="ui icon input">
                <input type="text" placeholder="搜索电影院或电影"><i class="search icon"></i>
              </div>
            </div>
          </div>
        </nav>
        <div class="content">
          <div class="header">
            <a href="#"><img src="../../resources/images/logo.png" alt="logo" class="logo"/></a>
          </div>
          <div class="pay-order-container">
            <h4 class="title">我的订单</h4>
            <table id="order_table" class="order-detail ui celled table">
              <thead>
                <tr>
                  <th>订单号</th>
                  <th>下单时间</th>
                  <th>总价</th>
                  <th>状态</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>00001</td>
                  <td>2016年6月12号 21:00</td>
                  <td>71元</td>
                  <td>待付款</td>
                  <td><a href="../html/order.html">
                      <button class="button ui">查看订单</button></a></td>
                </tr>
                <tr>
                  <td>00001</td>
                  <td>2016年6月12号 21:00</td>
                  <td>71元</td>
                  <td>待付款</td>
                  <td><a href="../html/order.html">
                      <button class="button ui">查看订单</button></a></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script src="../../resources/css/lib/semantic/dist/semantic.min.js"></script>
    <script type="text/javascript">
      $(function() {
    	  
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
  	  
        $.ajax({
          url:'../../order/orderList',
          success: function(responseJson) {
            var html = 
                '<tr>\
                  <td>00001</td>\
                  <td>2016年6月12号 21:00</td>\
                  <td>71元</td>\
                  <td>待付款</td>\
                  <td><a id="btn_order_id" href="../../order/order_id">\
                      <button class="button ui">查看订单</button></a></td>\
                </tr>'

            var orderState_map = {
            		  '0': '已完成',
            		  '1': '待付款',
            		  '2': '已取消'
            };

            var orderList = responseJson.data.list;
            var htmlList = '';
            var invalid_order_list = [];
            for (var orderIndex in orderList) {
              var order = orderList[orderIndex];
              if (order.state == '2') invalid_order_list.push(order.id);
              var createTime = new Date(order.time);
              htmlList += html.replace('order_id', order.id).replace('00001', order.id).replace('2016年', ''+createTime.getFullYear()+'年').replace('6月', ''+createTime.getMonth()+'月').replace('12号', ''+createTime.getDate()+'号').replace('21:00', ''+createTime.getHours()+':'+createTime.getMinutes()).replace('待付款', orderState_map[order.state]).replace('order_id', order.id).replace('71', order.prices);
            }
            $('#order_table').html(htmlList);
            for (var orderIndex in invalid_order_list) {
            	var order_id = invalid_order_list[orderIndex];
            	$('#btn_'+order_id).hide();
            }
          }
        })
      })
    </script>
  </body>
</html>