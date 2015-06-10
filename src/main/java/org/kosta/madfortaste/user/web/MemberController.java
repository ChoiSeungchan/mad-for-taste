package org.kosta.madfortaste.user.web;

import java.io.IOException;

import javax.validation.Valid;

import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value="/member/{path1}/{path2}")
	public String test(@PathVariable String path1, @PathVariable String path2) {
		return "user/"+path1+"/"+path2;
	}
	
	
	@RequestMapping(value="/memberRegisterForm")
	public String memberRegisterForm(@ModelAttribute Member member) {
		return "user/memberRegisterForm";
	}
	
	@RequestMapping(value="registerMember")
	public String registerMember(@Valid Member member, BindingResult result) {
		System.out.println(member.getImgFile().getSize());
		try {
			memberService.insertMember(member);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:member/result/member_register_result";
	}
	
}
