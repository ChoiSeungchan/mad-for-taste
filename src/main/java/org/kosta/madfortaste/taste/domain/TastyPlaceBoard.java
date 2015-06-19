package org.kosta.madfortaste.taste.domain;

import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.domain.Owner;

public class TastyPlaceBoard {
	private String replyNo;
	private String brNo;
	private String regDate;
	private String contents;
	private Member member;
	private Owner owner;
	private String user;
	public TastyPlaceBoard(String replyNo, String brNo, String regDate,
			String contents, Member member, Owner owner, String user) {
		super();
		this.replyNo = replyNo;
		this.brNo = brNo;
		this.regDate = regDate;
		this.contents = contents;
		this.member = member;
		this.owner = owner;
		this.user = user;
	}
	public TastyPlaceBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}
	public String getBrNo() {
		return brNo;
	}
	public void setBrNo(String brNo) {
		this.brNo = brNo;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "TastyPlaceBoard [replyNo=" + replyNo + ", brNo=" + brNo
				+ ", regDate=" + regDate + ", contents=" + contents
				+ ", member=" + member + ", owner=" + owner + ", user=" + user
				+ "]";
	}
	
}
