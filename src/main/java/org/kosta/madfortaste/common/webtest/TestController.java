package org.kosta.madfortaste.common.webtest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {
	
	@RequestMapping(value="test")
	public String test(HttpServletRequest req) {
		String realPath = new HttpServletRequestWrapper(req).getRealPath("/");
		System.out.println(realPath);
		return "redirect:";
	}
	
	@RequestMapping(value="/testForm")
	public String testForm() {
		return "test/testForm";
	}
	
	@Resource(name="testFileUploadPath")
	private String path;
	
	@RequestMapping(value="/fileUpload")
	public String fileUpload(TestVO vo, Model model, HttpServletRequest req) {
		String realPath = new HttpServletRequestWrapper(req).getRealPath("/");
		List<MultipartFile> fileList = vo.getFile();
		System.out.println("path = " + realPath + path);
		System.out.println("password = " + vo.getPassword());
		for (MultipartFile multipartFile : fileList) {
			System.out.println("multipartFile = " + multipartFile);
		}
		for (MultipartFile multipartFile : fileList) {
			System.out.println("OriginalFilename = " + multipartFile.getOriginalFilename());
			try {
				File dir = new File(path);
				if(!dir.exists()) dir.mkdir();
				multipartFile.transferTo(new File(realPath +path+multipartFile.getOriginalFilename()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(multipartFile.getOriginalFilename() + "이 성공적으로 저장되었습니다.");
		}
		return "test/fileupload_result";
	}
}
