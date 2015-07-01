package org.kosta.madfortaste.taste.domain;

public class Restaurant {

	private String resNo;
	private String resName;
	private String addrDo;
	private String addrSi;
	private String addrGu;
	private String addrDong;
	private String good;
	private String bad;

	public Restaurant() {
		super();
	}

	public Restaurant(String resName, String addrDo, String addrSi,
			String addrGu, String addrDong) {
		super();
		this.resName = resName;
		this.addrDo = addrDo;
		this.addrSi = addrSi;
		this.addrGu = addrGu;
		this.addrDong = addrDong;
	}

	public Restaurant(String resName, String addrDo, String addrSi,
			String addrGu, String addrDong, String good, String bad) {
		super();
		this.resName = resName;
		this.addrDo = addrDo;
		this.addrSi = addrSi;
		this.addrGu = addrGu;
		this.addrDong = addrDong;
		this.good = good;
		this.bad = bad;
	}

	public Restaurant(String resNo, String resName, String addrDo, String addrSi,
			String addrGu, String addrDong, String good, String bad) {
		super();
		this.resNo = resNo;
		this.resName = resName;
		this.addrDo = addrDo;
		this.addrSi = addrSi;
		this.addrGu = addrGu;
		this.addrDong = addrDong;
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

	public String getAddrDo() {
		return addrDo;
	}

	public void setAddrDo(String addrDo) {
		this.addrDo = addrDo;
	}

	public String getAddrSi() {
		return addrSi;
	}

	public void setAddrSi(String addrSi) {
		this.addrSi = addrSi;
	}

	public String getAddrGu() {
		return addrGu;
	}

	public void setAddrGu(String addrGu) {
		this.addrGu = addrGu;
	}

	public String getAddrDong() {
		return addrDong;
	}

	public void setAddrDong(String addrDong) {
		this.addrDong = addrDong;
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
				+ ", addrDo=" + addrDo + ", addrSi=" + addrSi + ", addrGu="
				+ addrGu + ", addrDong=" + addrDong + ", good=" + good
				+ ", bad=" + bad + "]";
	}

}
