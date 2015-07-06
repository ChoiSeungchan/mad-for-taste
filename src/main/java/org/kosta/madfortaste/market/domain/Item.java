package org.kosta.madfortaste.market.domain;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.web.multipart.MultipartFile;

public class Item {
	
	private int itemNo;
	
	@NumberFormat(style=Style.NUMBER)
	@Min(1)
	@Max(100)
	private int itemStock;
	
	@NumberFormat(style=Style.NUMBER)
	@Min(1)
	@Max(100)
	private int maxAmountAvailable;
	
	@NotEmpty
	private String itemName;
	
	@NumberFormat(style=Style.NUMBER)
	@Min(1)
	@Max(100000)
	private int itemPrice;
	private String itemEffect;
	
	@NumberFormat(style=Style.NUMBER)
	@Min(1)
	@Max(100000)
	private int itemEffectValue;
	
	@NotEmpty
	private String itemDetail;
	private String itemImgName;
	MultipartFile itemImg;
	
	@AssertTrue(message = "아이템 사진을 반드시 첨부하셔야 합니다.")
	public boolean isFileProvided() {
	    return (itemImg != null) && ( ! itemImg.isEmpty());
	}
	
	public Item() {
		super();
	}
	
	public Item(int itemNo) {
		super();
		this.itemNo = itemNo;
	}

	public Item(int itemStock, int maxAmountAvailable, String itemName,
			int itemPrice, String itemEffect, int itemEffectValue,
			String itemDetail, MultipartFile itemImg) {
		super();
		this.itemStock = itemStock;
		this.maxAmountAvailable = maxAmountAvailable;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemEffect = itemEffect;
		this.itemEffectValue = itemEffectValue;
		this.itemDetail = itemDetail;
		this.itemImg = itemImg;
	}
	
	public Item(int itemStock, int maxAmountAvailable, String itemName,
			int itemPrice, String itemEffect, int itemEffectValue,
			String itemDetail, String itemImgName) {
		super();
		this.itemStock = itemStock;
		this.maxAmountAvailable = maxAmountAvailable;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemEffect = itemEffect;
		this.itemEffectValue = itemEffectValue;
		this.itemDetail = itemDetail;
		this.itemImgName = itemImgName;
	}

	public Item(int itemNo, int itemStock, int maxAmountAvailable,
			String itemName, int itemPrice, String itemEffect,
			int itemEffectValue, String itemDetail, String itemImgName) {
		super();
		this.itemNo = itemNo;
		this.itemStock = itemStock;
		this.maxAmountAvailable = maxAmountAvailable;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemEffect = itemEffect;
		this.itemEffectValue = itemEffectValue;
		this.itemDetail = itemDetail;
		this.itemImgName = itemImgName;
	}

	public Item(int itemNo, int itemStock, int maxAmountAvailable,
			String itemName, int itemPrice, String itemEffect,
			int itemEffectValue, String itemDetail, String itemImgName,
			MultipartFile itemImg) {
		super();
		this.itemNo = itemNo;
		this.itemStock = itemStock;
		this.maxAmountAvailable = maxAmountAvailable;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemEffect = itemEffect;
		this.itemEffectValue = itemEffectValue;
		this.itemDetail = itemDetail;
		this.itemImgName = itemImgName;
		this.itemImg = itemImg;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
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

	public String getItemImgName() {
		return itemImgName;
	}

	public void setItemImgName(String itemImgName) {
		this.itemImgName = itemImgName;
	}

	public MultipartFile getItemImg() {
		return itemImg;
	}

	public void setItemImg(MultipartFile itemImg) {
		this.itemImg = itemImg;
	}

	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", itemStock=" + itemStock
				+ ", maxAmountAvailable=" + maxAmountAvailable + ", itemName="
				+ itemName + ", itemPrice=" + itemPrice + ", itemEffect="
				+ itemEffect + ", itemEffectValue=" + itemEffectValue
				+ ", itemDetail=" + itemDetail + ", itemImgName=" + itemImgName
				+ ", itemImg=" + itemImg + "]";
	}

}
