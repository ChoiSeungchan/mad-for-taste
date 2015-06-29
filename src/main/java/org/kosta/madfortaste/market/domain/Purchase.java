package org.kosta.madfortaste.market.domain;

import org.kosta.madfortaste.user.domain.Member;

public class Purchase {
	private String purchaseNo;
	private String purchaseDate;
	private String purchaseAmount;
	private Member member;
	private Item item;

	public Purchase() {
		super();
	}

	public Purchase(String purchaseAmount, Member member, Item item) {
		super();
		this.purchaseAmount = purchaseAmount;
		this.member = member;
		this.item = item;
	}

	public Purchase(String purchaseNo, String purchaseDate,
			String purchaseAmount, Member member, Item item) {
		super();
		this.purchaseNo = purchaseNo;
		this.purchaseDate = purchaseDate;
		this.purchaseAmount = purchaseAmount;
		this.member = member;
		this.item = item;
	}

	public String getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
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
		return "Purchase [purchaseNo=" + purchaseNo + ", purchaseDate="
				+ purchaseDate + ", purchaseAmount=" + purchaseAmount
				+ ", member=" + member + ", item=" + item + "]";
	}

}
