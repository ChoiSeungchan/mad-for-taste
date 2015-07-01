package org.kosta.madfortaste.market.domain;

public class Inventory {

	private String id;
	private int itemNo;
	private int itemAmount;
	private Item item;

	public Inventory() {
		super();
	}

	public Inventory(String id, int itemNo) {
		super();
		this.id = id;
		this.itemNo = itemNo;
	}

	public Inventory(String id, int itemNo, int itemAmount) {
		super();
		this.id = id;
		this.itemNo = itemNo;
		this.itemAmount = itemAmount;
	}

	public Inventory(String id, int itemNo, int itemAmount, Item item) {
		super();
		this.id = id;
		this.itemNo = itemNo;
		this.itemAmount = itemAmount;
		this.item = item;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", itemNo=" + itemNo + ", itemAmount="
				+ itemAmount + ", item=" + item + "]";
	}

}
