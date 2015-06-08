package org.kosta.madfortaste.common.webtest;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class TestVO {

	private String password;
	private List<MultipartFile> file;

	public TestVO() {
		super();
	}

	public TestVO(String password, List<MultipartFile> file) {
		super();
		this.password = password;
		this.file = file;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<MultipartFile> getFile() {
		return file;
	}

	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "TestVO [password=" + password + ", file=" + file + "]";
	}

}
