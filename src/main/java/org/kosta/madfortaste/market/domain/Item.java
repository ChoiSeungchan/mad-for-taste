package org.kosta.madfortaste.market.domain;

public class Item {
	private String itemNo;
	private int itemStock;
	private int maxAmountAvailable;
	private String itemName;
	private int itemPrice;
	private String itemEffect;
	private int itemEffectValue;
	private String itemDetail;

	public Item() {
		super();
	}

	public Item(int itemStock, int maxAmountAvailable, String itemName,
			int itemPrice, String itemEffect, int itemEffectValue,
			String itemDetail) {
		super();
		this.itemStock = itemStock;
		this.maxAmountAvailable = maxAmountAvailable;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemEffect = itemEffect;
		this.itemEffectValue = itemEffectValue;
		this.itemDetail = itemDetail;
	}

	public Item(String itemNo, int itemStock, int maxAmountAvailable,
			String itemName, int itemPrice, String itemEffect,
			int itemEffectValue, String itemDetail) {
		super();
		this.itemNo = itemNo;
		this.itemStock = itemStock;
		this.maxAmountAvailable = maxAmountAvailable;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemEffect = itemEffect;
		this.itemEffectValue = itemEffectValue;
		this.itemDetail = itemDetail;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	public int getMaxAmountAvailable() {
		return maxAmountAvailable;
	}

	public void setMaxAmountAvailable(int maxAmountAvailable) {
		this.maxAmountAvailable = maxAmountAvailable;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemEffect() {
		return itemEffect;
	}

	public void setItemEffect(String itemEffect) {
		this.itemEffect = itemEffect;
	}

	public int getItemEffectValue() {
		return itemEffectValue;
	}

	public void setItemEffectValue(int itemEffectValue) {
		this.itemEffectValue = itemEffectValue;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", itemStock=" + itemStock
				+ ", maxAmountAvailable=" + maxAmountAvailable + ", itemName="
				+ itemName + ", itemPrice=" + itemPrice + ", itemEffect="
				+ itemEffect + ", itemEffectValue=" + itemEffectValue
				+ ", itemDetail=" + itemDetail + "]";
	}

}
