package org.kosta.madfortaste.user.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class Member implements User{

	@Size(min=4, max=16)
	private String id;
	@Size(min=4, max=16)
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty
	private String city;
	@NotEmpty
	private String sigungu;
	@NotEmpty
	private String eupmyeondong;
	@NotEmpty
	private String address;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String birth;
	@NotEmpty
	private String tel;
	private int exp;
	private LevelInfo levelInfo;
	private int point;
	private Date joinDate;
	private String profileImg;
	private MultipartFile imgFile;

	public Member() {
		super();
	}
	
	public Member(String id) {
		super();
		this.id = id;
	}

	
	
	public Member(String id, String password, String name, String city,
			String sigungu, String eupmyeondong, String address, String gender,
			String birth, String tel) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.city = city;
		this.sigungu = sigungu;
		this.eupmyeondong = eupmyeondong;
		this.address = address;
		this.gender = gender;
		this.birth = birth;
		this.tel = tel;
	}

	public Member(String id, String password, String name, String city,
			String sigungu, String eupmyeondong, String address, String gender,
			String birth, String tel, MultipartFile imgFile) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.city = city;
		this.sigungu = sigungu;
		this.eupmyeondong = eupmyeondong;
		this.address = address;
		this.gender = gender;
		this.birth = birth;
		this.tel = tel;
		this.imgFile = imgFile;
	}
	
	public Member(String id, String password, String name, String city,
			String sigungu, String eupmyeondong, String address, String gender,
			String birth, String tel, int exp, LevelInfo levelInfo, int point,
			Date joinDate, String profileImg) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.city = city;
		this.sigungu = sigungu;
		this.eupmyeondong = eupmyeondong;
		this.address = address;
		this.gender = gender;
		this.birth = birth;
		this.tel = tel;
		this.exp = exp;
		this.levelInfo = levelInfo;
		this.point = point;
		this.joinDate = joinDate;
		this.profileImg = profileImg;
	}

	public String getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getEupmyeondong() {
		return eupmyeondong;
	}

	public void setEupmyeondong(String eupmyeondong) {
		this.eupmyeondong = eupmyeondong;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
		new LevelTable().calculateLevelInfo(this);
	}

	public LevelInfo getLevelInfo() {
		return levelInfo;
	}

	public void setLevelInfo(LevelInfo levelInfo) {
		this.levelInfo = levelInfo;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name
				+ ", city=" + city + ", sigungu=" + sigungu + ", eupmyeondong="
				+ eupmyeondong + ", address=" + address + ", gender=" + gender
				+ ", birth=" + birth + ", tel=" + tel + ", exp=" + exp
				+ ", levelInfo=" + levelInfo + ", point=" + point
				+ ", joinDate=" + joinDate + ", profileImg=" + profileImg
				+ ", imgFile=" + imgFile + "]";
	}

}
