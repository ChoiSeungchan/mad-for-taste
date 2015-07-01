package org.kosta.madfortaste.market.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.market.domain.Inventory;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.domain.Purchase;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MarketDaoImpl implements MarketDao{

	@Inject
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int getTotalItemCount() {
		return sqlSessionTemplate.selectOne("market.getTotalItemCount");
	}

	@Override
	public Item insertItem(Item item) {
		sqlSessionTemplate.insert("market.insertItem",item);
		return item;
	}

	@Override
	public int insertPurchase(String memberId, int itemNo, int purchaseAmount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("itemNo", itemNo);
		map.put("purchaseAmount", purchaseAmount);
		return sqlSessionTemplate.insert("market.insertPurchase", map);
	}

	@Override
	public Item selectItem(int itemNo) {
		return sqlSessionTemplate.selectOne("market.selectItem", itemNo);
	}

	@Override
	public List<Item> getItemsByPaging(Page page) {
		return sqlSessionTemplate.selectList("market.getItemsByPaging", page);
	}

	@Override
	public void updateItem(Item item) {
		sqlSessionTemplate.update("market.updateItem", item);
	}

	@Override
	public void deleteItem(int itemNo) {
		sqlSessionTemplate.delete("market.deleteItem", itemNo);
	}

	@Override
	public int getTotalPurchaseCount() {
		return sqlSessionTemplate.selectOne("getTotalPurchaseCount");
	}

	@Override
	public List<Purchase> getPurchaseList(String memberId) {
		return sqlSessionTemplate.selectList("market.getPurchaseList", memberId);
	}

	@Override
	public List<Purchase> getPurchaseListByPaging(String memberId, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("page", page);
		return sqlSessionTemplate.selectList("market.getPurchaseListByPaging", map);
	}

	@Override
	public int insertInventory(Inventory inven) {
		return sqlSessionTemplate.insert("market.insertInventory", inven);
	}

	@Override
	public int getTotalInvenCount(String id) {
		return sqlSessionTemplate.selectOne("market.getTotalInvenCount", id);
	}
	
	@Override
	public Inventory selectInventory(Inventory inventory) {
		return sqlSessionTemplate.selectOne("market.selectInventory", inventory);
	}

	@Override
	public List<Inventory> selectInventories(String id, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("page", page);
		return sqlSessionTemplate.selectList("market.selectInventories", map);
	}

	@Override
	public boolean ItemExistInInventory(int itemNo, String id) {
		boolean isExist = false;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("itemNo", itemNo);
		map.put("id", id);
		int i = sqlSessionTemplate.selectOne("market.ItemExistInInventory", map);
		if(i==1) isExist = true;
		return isExist;
	}

	@Override
	public void updateInventory(Inventory inven) {
		sqlSessionTemplate.update("updateInventory",inven);
	}

}
