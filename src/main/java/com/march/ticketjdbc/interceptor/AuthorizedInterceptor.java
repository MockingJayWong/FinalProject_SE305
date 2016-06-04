package com.march.ticketjdbc.interceptor;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.march.ticketjdbc.service.GetJsonStringService;

public class AuthorizedInterceptor implements HandlerInterceptor{
	@Autowired
	private GetJsonStringService jsonService;
	
	private static final String[] INTERCEPTOR_URI = {"/createOrder"};
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean interceptorFlag = false;
		String uri = request.getRequestURI();

		for (String str : INTERCEPTOR_URI) {
			if (uri.contains(str)) {
				interceptorFlag = true;
				break;
			}
		}

		if (!interceptorFlag) {
			return true;
		}
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String currentUri = request.getParameter("currentUrl");
		boolean loginFlag = false;
		
		//若session里面的username为空,则查看cookie中是否有记录,否则照常进行
		if (username == null) {
			Cookie usernameCookie = null;
			Cookie passwordCookie = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("username")) {
						usernameCookie = cookie;
					} else if (cookie.getName().equals("password")) {
						passwordCookie = cookie;
					}
				}
			}
			
			//若cookie中无记录,跳转登陆页面,否则检验cookie中记录是否正确
			if (usernameCookie != null && passwordCookie != null && usernameCookie.getValue() != "" && passwordCookie.getValue() != "") {
				username = usernameCookie.getValue();
				String password = passwordCookie.getValue();
				
				//若cookie中的记录不正确,则清除记录,正确则登陆并设置session
				Map<String, Object> map = (Map<String, Object>) jsonService.userLogin(username, password);
				if (((String)map.get("status")).equals("success")) {
					//session无记录，cookie记录正确,登陆成功
			        request.getSession().setAttribute("username", username);
			        loginFlag = true;
				} else {
					//session无记录，cookie记录错误，跳转登陆页面
					usernameCookie.setValue(null);
					passwordCookie .setValue(null);
					
					usernameCookie.setPath("/");  
					passwordCookie.setPath("/");
					
			        response.addCookie(usernameCookie); 
			        response.addCookie(passwordCookie);
			        
			        loginFlag = false;
				}
			} else {
				//session及cookie均无记录，跳转登陆页面
				loginFlag = false;
			}
		} else {
			//session存在username,已登陆用户
			loginFlag = true;
		}
		
		try {
			if (loginFlag) {
				response.sendRedirect(currentUri);
				return true;
			} else {
				response.sendRedirect("/ticketjdbc/login");
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
