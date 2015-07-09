package org.kosta.madfortaste.common.webtest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping(value="test")
	public String test(HttpServletRequest req) {
		String realPath = new HttpServletRequestWrapper(req).getRealPath("/");
		System.out.println(realPath);
		return "test/test";
	}
}
