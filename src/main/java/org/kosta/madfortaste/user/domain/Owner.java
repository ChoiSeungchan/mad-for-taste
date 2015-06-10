package org.kosta.madfortaste.user.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Owner implements User{
	private String ownerId;
	private String password;
	private String name;
	private String tel;
	private String email;
	private String joinDate;
	private MultipartFile imgFile;
	private String profileImg;
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Owner(String ownerId, String password, String name, String tel,
			String email, String joinDate, MultipartFile imgFile,
			String profileImg) {
		super();
		this.ownerId = ownerId;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.joinDate = joinDate;
		this.imgFile = imgFile;
		this.profileImg = profileImg;
	}
	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", password=" + password
				+ ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", joinDate=" + joinDate + ", imgFile=" + imgFile
				+ ", profileImg=" + profileImg + "]";
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

}
