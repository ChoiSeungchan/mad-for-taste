package org.kosta.madfortaste.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
	
	@RequestMapping(value="/ownerRegisterForm")
	public String ownerRegisterForm() {
		return "user/ownerRegisterForm";
	}
}
