package org.kosta.madfortaste.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private LoginService loginService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println(request.getRequestURI()+" 인터셉터 진입 성공");
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
		super.afterCompletion(request, response, handler, ex);
		HttpSession session = request.getSession(false);
		if(session!=null) {
			Member member = (Member) session.getAttribute("Member");
			if(member!=null) loginService.reLogin(member, session, request);
		}
		
	}
}
