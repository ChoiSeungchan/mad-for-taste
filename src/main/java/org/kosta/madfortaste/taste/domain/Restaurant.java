package org.kosta.madfortaste.taste.domain;

public class Restaurant {

	private String resNo;
	private String resName;
	private String city;
	private String sigungu;
	private String eupmyeondong;
	private String good;
	private String bad;

	public Restaurant() {
		super();
	}

	public Restaurant(String resName, String city, String sigungu,
			String eupmyeondong) {
		super();
		this.resName = resName;
		this.city = city;
		this.sigungu = sigungu;
		this.eupmyeondong = eupmyeondong;
	}

	public Restaurant(String resNo, String resName, String city,
			String sigungu, String eupmyeondong, String good, String bad) {
		super();
		this.resNo = resNo;
		this.resName = resName;
		this.city = city;
		this.sigungu = sigungu;
		this.eupmyeondong = eupmyeondong;
		this.good = good;
		this.bad = bad;
	}

	public String getResNo() {
		return resNo;
	}

	public void setResNo(String resNo) {
		this.resNo = resNo;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
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

	public String getGood() {
		return good;
	}

	public void setGood(String good) {
		this.good = good;
	}

	public String getBad() {
		return bad;
	}

	public void setBad(String bad) {
		this.bad = bad;
	}

	@Override
	public String toString() {
		return "Restaurant [resNo=" + resNo + ", resName=" + resName
				+ ", city=" + city + ", sigungu=" + sigungu + ", eupmyeondong="
				+ eupmyeondong + ", good=" + good + ", bad=" + bad + "]";
	}

}
