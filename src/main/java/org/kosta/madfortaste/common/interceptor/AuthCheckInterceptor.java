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
		HttpSession session = request.getSession(false);
		if(session!=null) {
			Member member = (Member) session.getAttribute("member");
			if(member!=null) {
				loginService.reLogin(member, session, request);
				System.out.println("*** MEMBER ID = '" + member.getId() + "' 세션 유지중" + " ***");
				
			}
		}
		System.out.println(request.getRequestURI()+" 인터셉터 진입 성공");
		return true;
	}
	
}
