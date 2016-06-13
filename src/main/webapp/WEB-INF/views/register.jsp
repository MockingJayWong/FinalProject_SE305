<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
    <link href="../resources/css/lib/semantic/dist/semantic.min.css" rel="stylesheet">
    <link href="../resources/css/login.css" rel="stylesheet">
	</head>
  <body>
    <div class="whole">
      <div class="ui main container"> 
        <div class="content">
          <div class="center-container">
            <form id="register_form">
              <div class="title">注册</div>
              <div class="input-item">
                <label for="username">用户名</label>
                <input id="username" name="username" type="text" id="username">
                <label for="username" class="error"></label>
              </div>
              <div class="input-item">
                <label for="password">密码</label>
                <input id="password" name="password" type="password" id="password_1">
                <label for="password" class="error"></label>
              </div>
              <div class="input-item">
                <label for="password2">确认密码</label>
                <input id="password2" name="password2" type="password" id="password_2">
                <label for="password2" class="error"></label>
              </div>
              <div class="input-item">
                <label for="email">邮箱</label>
                <input id="email" name="email" type="text" id="email">
                <label for="email" class="error"></label>
              </div>
              <div class="input-item">
                <label for="phone">电话号码</label>
                <input id="telephone" name="telephone" type="text" id="phone">
                <label for="telephone" class="error"></label>
              </div>
              <button id="register_btn" type="submit" class="button ui">注册</button>
              <button class="button ui"><a href="login">已有账号，去登录</a></button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
    <script src="../resources/css/lib/semantic/dist/semantic.min.js"></script>
    <script src="http://malsup.github.io/min/jquery.form.min.js"></script>
    <script type="text/javascript">
    $(function() {    	
    	// register form validation
    	$("#register_form").validate({
    		debug: true,
    		rules: {
    			username: {
    				required: true,
    				rangelength:[6, 16]
    			},
    			password: {
    				required: true,
    	      rangelength:[6, 16]
    			},
    			password2: {
    				required: true,
    				equalTo: '#password'
    			},
    			email: {
    				required:true,
    				email:true
    			},
    			telephone: {
    				required:true,
    				digits:true,
    				rangelength:[11, 11]
    			}
    		},
    		
    		messages: {
          username: {
            required: "请输入用户名",
            rangelength: "长度为6~16个字符"
          },
          email: {
            required: "请输入邮件地址",
            email: "邮件格式不正确"
          },
          telephone: {
        	  required: "请输入手机号码",
        	  digits:"手机号码格式不正确",
            rangelength:"手机号码格式不正确"
          },
          password: {
        	  required: "请输入用户密码",
        	  rangelength: "长度为6~16个字符"
          },
          password2: {
        	  required: "请确认密码",
        	  equalTo: "确认密码不一致"
          }
        },
        
        submitHandler: function(form) {
        	$(form).ajaxSubmit({
        		url:'register',
        		type:'POST',
        		success:function(responseJson) {
              var status = responseJson.status;
              switch(status) {
                case "fail":
                  var error_msg = responseJson.data.user;
                  for (var key in error_msg) {
                    var value = error_msg[key];
                    $('#'+key+'+label').html(value).css('display','block'); ;
                  }
                  break;
                case "success":
                  window.location.href= "../";
  	        	  break;
                default:
                  break;
              }
            }
        	})
        }
    	});
    })
    </script>
  </body>
</html>