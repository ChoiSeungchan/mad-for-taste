package org.kosta.madfortaste.common.domain;

public class NaverMap {

	private String title;
	private String category;
	private String telephone;
	private String address;
	private String roadAddress;
	private String mapx;
	private String mapy;

	public NaverMap() {
		super();
	}

	public NaverMap(String title, String category, String telephone,
			String address, String roadAddress, String mapx, String mapy) {
		super();
		this.title = title;
		this.category = category;
		this.telephone = telephone;
		this.address = address;
		this.roadAddress = roadAddress;
		this.mapx = mapx;
		this.mapy = mapy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	public String getMapx() {
		return mapx;
	}

	public void setMapx(String mapx) {
		this.mapx = mapx;
	}

	public String getMapy() {
		return mapy;
	}

	public void setMapy(String mapy) {
		this.mapy = mapy;
	}

	@Override
	public String toString() {
		return "NaverMap [title=" + title + ", category=" + category
				+ ", telephone=" + telephone + ", address=" + address
				+ ", roadAddress=" + roadAddress + ", mapx=" + mapx + ", mapy="
				+ mapy + "]";
	}

}
