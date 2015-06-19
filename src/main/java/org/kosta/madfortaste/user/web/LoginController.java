package org.kosta.madfortaste.user.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.domain.User;
import org.kosta.madfortaste.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "login")
	public String login(String id, String password, HttpServletRequest req) {
		if (!(id == null || id.equals("")) 	&& !(password == null || password.equals(""))) {
			loginService.login(id, password, req);
		}
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "loginAjax", method=RequestMethod.POST)	
	public List<String> loginAjax (String id, String password, HttpServletRequest req) {
		List<String> list = new ArrayList<String>();
		if (!(id == null || id.equals("")) 	&& !(password == null || password.equals(""))) {
			boolean successOrFailure = loginService.login(id, password, req);
			if(successOrFailure==true)	list.add("success");
			else list.add("failure");
		} else {
			list.add("empty");
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "maintainAuthSession", method=RequestMethod.POST)	
	public void maintainAuthSession (HttpSession session, HttpServletRequest req) {
		Member member = (Member) session.getAttribute("member");
		if (!(member.getId() == null || member.getId().equals(""))
				&& !(member.getPassword() == null || member.getPassword()
						.equals(""))) {
		loginService.login(member.getId(), member.getPassword(), req);
		}
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "logoutAjax")
	public void logoutAjax (HttpSession session) {
		session.invalidate();
	}
	
	@RequestMapping(value = "reLogin")
	public String reLogin(HttpSession session, HttpServletRequest req) {
		User user = (User) session.getAttribute("member");
		if(user==null)
			user = (User) session.getAttribute("owner");
		if(user!=null)
			loginService.reLogin(user, session, req);
		return "redirect:/";
	}
	
	@RequestMapping(value = "reLogin/{path}")
	public String reLoginByPath(@PathVariable String path, HttpSession session, HttpServletRequest req) {
		User user = (User) session.getAttribute("member");
		if(user==null)
			user = (User) session.getAttribute("owner");
		if(user!=null)
			loginService.reLogin(user, session, req);
		return "redirect:/" + path;
	}
}
