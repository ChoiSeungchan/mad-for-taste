package org.kosta.madfortaste.taste.domain;

public class TastyPlaceMark {
	private String brNo;
	private String id;
	private String mark;
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public TastyPlaceMark(String brNo, String id, String mark) {
		super();
		this.brNo = brNo;
		this.id = id;
		this.mark = mark;
	}
	public TastyPlaceMark() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TastyPlaceMark [brNo=" + brNo + ", id=" + id + ", mark=" + mark
				+ "]";
	}
	
}
