package org.kosta.madfortaste.market.service;


import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.market.dao.MarketDao;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.domain.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketServiceImpl implements MarketService{
	
	@Autowired
	private MarketDao marketDao;

	@Override
	public int getTotalItemCount() {
		return marketDao.getTotalItemCount();
	}

	@Override
	public Item insertItem(Item item) {
		return marketDao.insertItem(item);
	}

	@Override
	public int insertPurchase(String memberId, int itemNo, int purchaseAmount) {
		return marketDao.insertPurchase(memberId, itemNo, purchaseAmount);
	}

	@Override
	public Item selectItem(int itemNo) {
		return marketDao.selectItem(itemNo);
	}

	@Override
	public List<Item> getItemsByPaging(int currentPage) {
		int totalItemCount = marketDao.getTotalItemCount();
		Page page = new Page(totalItemCount);
		page.setPageSize(8);
		page.setCurrentPage(currentPage);
		List<Item> itemList = null;
		if(currentPage <= page.getPageCount()) {
			itemList = marketDao.getItemsByPaging(page);
		}
		return itemList;
	}

	@Override
	public void updateItem(Item item) {
		marketDao.updateItem(item);
	}

	@Override
	public void deleteItem(int itemNo) {
		marketDao.deleteItem(itemNo);
	}

	@Override
	public int getTotalPurchaseCount() {
		return marketDao.getTotalPurchaseCount();
	}

	@Override
	public List<Purchase> getPurchaseList(String memberId) {
		return marketDao.getPurchaseList(memberId);
	}

	@Override
	public List<Purchase> getPurchaseListByPaging(String memberId, Page page) {
		return marketDao.getPurchaseListByPaging(memberId, page);
	}

}
