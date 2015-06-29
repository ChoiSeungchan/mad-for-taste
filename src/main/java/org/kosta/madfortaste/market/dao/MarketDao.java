package org.kosta.madfortaste.market.dao;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.domain.Purchase;

public interface MarketDao {
	
	public int getTotalItemCount();
	
	public Item insertItem(Item item);
	
	public int insertPurchase(String memberId, int itemNo, int purchaseAmount);
	
	public Item selectItem(int itemNo);

	public List<Item> getItemsByPaging(Page page);

	public void updateItem(Item item);

	public void deleteItem(int itemNo);

	public int getTotalPurchaseCount();

	public List<Purchase> getPurchaseList(String memberId);

	public List<Purchase> getPurchaseListByPaging(String memberId, Page page);

}
