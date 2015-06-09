package org.kosta.madfortaste.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping(value="/memberRegisterForm")
	public String memberRegisterForm() {
		return "user/memberRegisterForm";
	}
}
