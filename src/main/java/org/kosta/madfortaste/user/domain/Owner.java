package org.kosta.madfortaste.user.domain;

import org.springframework.web.multipart.MultipartFile;

public class Owner implements User{
	private String ownerId;
	private String password;
	private String name;
	private String tel;
	private String email;
	private String joinDate;
	private MultipartFile profileImg;
	public Owner(String ownerId, String password, String name, String tel,
			String email, String joinDate, MultipartFile profileImg) {
		super();
		this.ownerId = ownerId;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.joinDate = joinDate;
		this.profileImg = profileImg;
	}
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", password=" + password
				+ ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", joinDate=" + joinDate + ", profileImg=" + profileImg + "]";
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
	public MultipartFile getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(MultipartFile profileImg) {
		this.profileImg = profileImg;
	}
	
}
