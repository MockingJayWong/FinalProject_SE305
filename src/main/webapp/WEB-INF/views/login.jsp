<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <link href="../resources/css/lib/semantic/dist/semantic.min.css" rel="stylesheet">
    <link href="../resources/css/login.css" rel="stylesheet">
  </head>
  <body>
    <div class="whole">
      <div class="ui main container"> 
        <div class="content">
          <div class="center-container">
            <form id="login_form">
              <span id="error_msg" class="error">用户名或密码错误</span>
              <div class="title">登录</div>
              <div class="input-item">
                <label for="username">用户名</label>
                <input type="text" id="username" name="username">
              </div>
              <div class="input-item">
                <label for="password">密码</label>
                <input type="password" id="password" name="password">
              </div>
              <button id="login_btn" type="submit" class="button ui">登录</button>
              <button class="button ui"><a href="/register">还没账号，去注册</a></button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script src="../resources/css/lib/semantic/dist/semantic.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="http://malsup.github.io/min/jquery.form.min.js"></script>
    <script type="text/javascript">
    
    $(function() {
    	$('#error_msg').hide();
    	
    	$('input').change(function() {
    		$('#error_msg').hide();
    	});
    	
    	$('#login_form').validate({
    		submitHandler: function(form) {
          $(form).ajaxSubmit({
            url:'login',
    	      type:'POST',
    	      success:function(responseJson) {
    	        var status = responseJson.status;
    	        switch(status) {
    	          case "fail":
    	        	  $('#error_msg').show();
    	            break;
    	          case "success":
    	        	  window.location.href= "/" + responseJson.data.url;
    	        	  break;
    	          default:
    	            break;
    	        }
    	      }
    	    });
    		}
    	});    	
    });
    
    </script>
  </body>
</html>