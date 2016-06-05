package com.march.ticketjdbc.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
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
		String userId = (String) session.getAttribute("userId");
		String currentUrl = request.getParameter("currentUrl");
		boolean loginFlag = false;
		
		//若session里面的userId为空,则查看cookie中是否有记录,否则照常进行
		if (userId == null) {
			Cookie userIdCookie = null;
			Cookie passwordCookie = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("userId")) {
						userIdCookie = cookie;
					} else if (cookie.getName().equals("password")) {
						passwordCookie = cookie;
					}
				}
			}
			
			//若cookie中无记录,跳转登陆页面,否则检验cookie中记录是否正确
			if (userIdCookie != null && passwordCookie != null && userIdCookie.getValue() != "" && passwordCookie.getValue() != "") {
				userId = userIdCookie.getValue();
				String password = passwordCookie.getValue();
				
				//若cookie中的记录不正确,则清除记录,正确则登陆并设置session
				Map<String, Object> map = (Map<String, Object>) jsonService.userLoginById(userId, password);
				if (((String)map.get("status")).equals("success")) {
					//session无记录，cookie记录正确,登陆成功
			        request.getSession().setAttribute("userId", userId);
			        loginFlag = true;
				} else {
					//session无记录，cookie记录错误，跳转登陆页面
					userIdCookie.setValue(null);
					passwordCookie .setValue(null);
					
					userIdCookie.setPath("/");  
					passwordCookie.setPath("/");
					
			        response.addCookie(userIdCookie); 
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
				return true;
			} else {
				String jsonObject = "{\"status\":\"fail\",\"url\":\"" + currentUrl + "\"}";
				String contentType = "application/json";  
		        response.setContentType(contentType);  
		        response.setCharacterEncoding("UTF-8");
		        PrintWriter out = response.getWriter();  
		        out.print(jsonObject);  
		        out.flush();  
		        out.close();
		        return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
