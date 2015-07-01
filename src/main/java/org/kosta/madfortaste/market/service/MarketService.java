package org.kosta.madfortaste.market.service;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.market.domain.Inventory;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.domain.Purchase;


public interface MarketService {
		
public int getTotalItemCount();
	
	public Item insertItem(Item item);
	
	public int insertPurchase(String memberId, int itemNo, int purchaseAmount);
	
	public Item selectItem(int itemNo);

	public List<Item> getItemsByPaging(int currentPage);

	public void updateItem(Item item);

	public void deleteItem(int itemNo);

	public int getTotalPurchaseCount();

	public List<Purchase> getPurchaseList(String memberId);

	public List<Purchase> getPurchaseListByPaging(String memberId, Page page);

	public void itemPurchaseService(Inventory inven);


}
