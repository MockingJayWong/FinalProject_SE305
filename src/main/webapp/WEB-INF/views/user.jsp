<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <link href="../resources/css/lib/semantic/dist/semantic.min.css" rel="stylesheet">
    <link href="../resources/css/user.css" rel="stylesheet">
  </head>
  <body>
    <div class="whole">
      <div class="ui main container">
        <nav class="navigator">
          <div class="ui menu">
	          <a href=".." class="item">首页</a>
	          <a id="menu_item_1" href="login" class="item">登陆</a>
	          <a id="menu_item_2" href="register" class="item">注册</a>
	          <a id="menu_item_3" href="user/orderList" class="item">我的订单</a>
            <div class="right item">
              <div class="ui icon input">
                <input type="text" placeholder="搜索电影院或电影"><i class="search icon"></i>
              </div>
            </div>
          </div>
        </nav>
        <div class="content">
          <div class="center-container">
            <div class="user-info">
              <div class="tip">修改成功</div>
              <div class="title">个人信息</div>
              <dl class="user-undefined user-info info">
                <dt class="label">用户名</dt>
                <dd class="value">
                  <input id='username' value="AAA" readonly="readonly"/>
                </dd>
              </dl>
              <dl class="user-undefined user-info info">
                <dt class="label">邮箱</dt>
                <dd class="value">
                  <input id='email' value="110120130@qq.com" readonly="readonly"/>
                </dd>
              </dl>
              <dl class="user-undefined user-info info">
                <dt class="label">电话号码</dt>
                <dd class="value">
                  <input id='telephone' value="12922029832" readonly="readonly"/>
                </dd>
              </dl>
              <button id='modify_btn' class="button ui">修改</button>
              <button id='confirm_modify_btn' class="button ui">确认修改</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script src="../resources/css/lib/semantic/dist/semantic.min.js"></script>
    <script type="text/javascript">
    
    $(function() {
    	
    	$('.tip, #confirm_modify_btn').hide();
    	
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
        $('#menu_item_1').attr('href', 'user').html('Hello, '+username);
        $('#menu_item_2').attr('href', 'logOut').html('退出');
      } else {
          $('#menu_item_3').hide();
      }
    	
    	var userId = getUrlParam('userId');
    	
    	$.ajax({
    		url:'user/info',
    		type:'GET',
    		data:{userId:userId},
    		success: function(responseJson) {
    			var status = responseJson.status;
    			switch(status) {
	    			case "success":
	    				user = responseJson.data.user;
	    				$('#username').html(user.username);
	    				$('#email').html(user.email);
	    				$('#telephone').html(user.telephone);
	    				break;
	    			default:
	    				break;
    			}
    		}
    	});
    	
    	/* $('#modify_btn').click(function() {
    		$('#telephone').removeAttr('readonly');
    		$('#email').removeAttr('readonly');
    		$('#modyfy_btn').hide();
    		$('#confirm_modify_btn').show().click(function) {
    			$.ajax({
    				url:'modify'
    			})
    		})
    	}) */
    	
    })
    
     function getUrlParam(name) {
       var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
       var r = window.location.search.substr(1).match(reg);  //匹配目标参数
       if (r != null) return unescape(r[2]); return null; //返回参数值
     }
    
    </script>
  </body>
</html>