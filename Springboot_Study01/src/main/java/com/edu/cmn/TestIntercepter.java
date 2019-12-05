package com.edu.cmn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestIntercepter extends HandlerInterceptorAdapter {
/*
 스트링부트는  인터셉터 설정클래스 생성필요
 ->WebMvcConfigurer 구현
*/
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("인터셉터 pre : " + request.getRequestURL());
		//인터셉터 pre : http://localhost:8080/test1
		
		//true일시 계속진행, false면 중단
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerMethod a = (HandlerMethod) handler;
		System.out.println("인터셉터 post : " + a.getMethod().toString());
		//인터셉터 post : public java.lang.String com.edu.cmn.TestController.testPage(java.lang.String)
	}
	
}
