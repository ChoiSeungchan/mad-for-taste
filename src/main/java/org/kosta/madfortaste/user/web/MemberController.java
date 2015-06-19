package org.kosta.madfortaste.user.web;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.service.LoginService;
import org.kosta.madfortaste.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="member/{viewName1}/{viewName2}")
	public String test(@PathVariable String viewName1, @PathVariable String viewName2) {
		return "user/" + viewName1 + "/" +viewName2;
	}
	
	@RequestMapping(value="memberRegisterForm")
	public String memberRegisterForm(@ModelAttribute Member member) {
		return "user/memberRegisterForm";
	}

	@RequestMapping(value="memberUpdateForm")
	public String updateMemberForm (@ModelAttribute Member member) {
		return "user/memberUpdateForm";
	}
	
	@RequestMapping(value="registerMember", method=RequestMethod.POST)
	public String registerMember(@Valid Member member, BindingResult result,  HttpServletRequest req) {
		if(result.hasErrors()){
			return "user/memberRegisterForm";
		}
		try {
			memberService.insertMember(member, req);
			loginService.login(member.getId(), member.getPassword(), req);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:member/result/member_register_result";
	}
	
	@RequestMapping(value="updateMember", method=RequestMethod.POST)
	public String updateMember(@Valid Member member, BindingResult result, Model model, HttpServletRequest req) {
		if(result.hasErrors()){
			return "user/memberRegisterForm";
		}
		try {
			memberService.updateMember(member, req);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:reLogin";
	}
	
	@RequestMapping(value="deleteMember")
	public String deleteMember(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if(member!=null)
		memberService.deleteMember(member.getId());		
		return "redirect:logout";
	}
	
	@RequestMapping(value="upExp")
	public String upExp(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if(member!=null)
		memberService.upExp(member.getId(), new Random().nextInt(500));
		return "redirect:reLogin";
	}
	
	@RequestMapping(value="upPoint")
	public String upPoint(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if(member!=null)
		memberService.upPoint(member.getId(), new Random().nextInt(500));
		return "redirect:reLogin";
	}
	
	@RequestMapping(value="downPoint")
	public String downPoint(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if(member!=null)
		memberService.downPoint(member.getId(), new Random().nextInt(500));
		return "redirect:reLogin";
	}
}
