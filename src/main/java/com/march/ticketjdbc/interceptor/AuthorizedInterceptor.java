package com.march.ticketjdbc.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.march.ticketjdbc.service.GetJsonStringService;

public class AuthorizedInterceptor implements HandlerInterceptor{
	@Autowired
	private GetJsonStringService jsonService;
	
	private static final String[] INTERCEPTOR_URI = {"/createOrder","user/info", "account/user/orderList", "order/orderList"};
	
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
		boolean loginFlag = false;
		
		//鑻ession閲岄潰鐨剈serId涓虹┖,鍒欐煡鐪媍ookie涓槸鍚︽湁璁板綍,鍚﹀垯鐓у父杩涜
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
			
			//鑻ookie涓棤璁板綍,璺宠浆鐧婚檰椤甸潰,鍚﹀垯妫�楠宑ookie涓褰曟槸鍚︽纭�
			if (userIdCookie != null && passwordCookie != null && userIdCookie.getValue() != "" && passwordCookie.getValue() != "") {
				userId = userIdCookie.getValue();
				String password = passwordCookie.getValue();
				
				//鑻ookie涓殑璁板綍涓嶆纭�,鍒欐竻闄よ褰�,姝ｇ‘鍒欑櫥闄嗗苟璁剧疆session
				Map<String, Object> map = (Map<String, Object>) jsonService.userLoginById(userId, password);
				if (((String)map.get("status")).equals("success")) {
					//session鏃犺褰曪紝cookie璁板綍姝ｇ‘,鐧婚檰鎴愬姛
			        request.getSession().setAttribute("userId", userId);
			        loginFlag = true;
				} else {
					//session鏃犺褰曪紝cookie璁板綍閿欒锛岃烦杞櫥闄嗛〉闈�
					userIdCookie.setValue(null);
					passwordCookie .setValue(null);
					
					userIdCookie.setPath("/");  
					passwordCookie.setPath("/");
					
			        response.addCookie(userIdCookie); 
			        response.addCookie(passwordCookie);
			        
			        loginFlag = false;
				}
			} else {
				//session鍙奵ookie鍧囨棤璁板綍锛岃烦杞櫥闄嗛〉闈�
				loginFlag = false;
			}
		} else {
			//session瀛樺湪username,宸茬櫥闄嗙敤鎴�
			loginFlag = true;
		}

		try {
			if (loginFlag) {
				return true;
			} else {
			    String jsonObject = "{\"status\":\"fail\",\"url\":\"ticketjdbc/account/login\"}";
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
