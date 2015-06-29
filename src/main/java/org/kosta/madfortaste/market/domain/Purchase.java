package org.kosta.madfortaste.market.domain;

import java.util.Date;

import org.kosta.madfortaste.user.domain.Member;

public class Purchase {
	private int purchaseNo;
	private int purchaseAmount;
	private Date purchaseDate;
	private Member member;
	private Item item;

	public Purchase() {
		super();
	}

	public Purchase(int purchaseAmount, Member member, Item item) {
		super();
		this.purchaseAmount = purchaseAmount;
		this.member = member;
		this.item = item;
	}

	public Purchase(int purchaseNo, int purchaseAmount, Date purchaseDate,
			Member member, Item item) {
		super();
		this.purchaseNo = purchaseNo;
		this.purchaseAmount = purchaseAmount;
		this.purchaseDate = purchaseDate;
		this.member = member;
		this.item = item;
	}

	public int getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public int getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseNo=" + purchaseNo + ", purchaseAmount="
				+ purchaseAmount + ", purchaseDate=" + purchaseDate
				+ ", member=" + member + ", item=" + item + "]";
	}

}
