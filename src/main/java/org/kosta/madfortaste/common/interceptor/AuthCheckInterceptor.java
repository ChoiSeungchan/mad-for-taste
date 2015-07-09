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
		String uri = request.getRequestURI();
		String root = request.getContextPath();
		String path = uri.replace(root+"/", "");
		Member member = null;
		HttpSession session = request.getSession(false);
		if (session != null) {
			member = (Member) session.getAttribute("member");
		}
		
		if((!(path.contains("member") || path.contains("owner")) &&
				path.contains("egister")) || path.contains("pdate") || path.contains("elete")){
				if (member == null) {
					response.sendRedirect("loginForm?path="+path);
					return false;
				}
		} else if (path.contains("Admin")) {
			if(member==null || member.getExp()<10000000) {
				response.sendRedirect("/madfortaste/loginForm?path="+path);
				return false;
			}
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
		super.afterCompletion(request, response, handler, ex);
		HttpSession session = request.getSession(false);
		if(session!=null) {
			Member member = (Member) session.getAttribute("member");
			if(member!=null) { 
				loginService.reLogin(member, session, request);
			}
		}
	}
}
