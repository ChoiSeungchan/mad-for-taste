package org.kosta.madfortaste.user.web;

import javax.validation.Valid;

import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.user.domain.Owner;
import org.kosta.madfortaste.user.domain.OwnerForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
	
	@RequestMapping(value="/{path}")
	public String ownerRegisterForm(@ModelAttribute OwnerForm ownerForm,@PathVariable String path) {
		return "user/"+path;
	}
	
	@RequestMapping("/register_access")
	public String ownerRegisterAccess(@Valid OwnerForm ownerForm,BindingResult result,Owner owner,TastyPlace tastyPlace){
		if(result.hasErrors()){
			return "user/ownerRegisterForm"; // 유효성 검사에 에러가 있으면 가입폼으로 다시 보낸다. 
		}
		
		return "user/result/owner_register_result";
	}
}
