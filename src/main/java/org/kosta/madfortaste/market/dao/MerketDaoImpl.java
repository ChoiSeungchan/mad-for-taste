package org.kosta.madfortaste.market.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.domain.Purchase;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MerketDaoImpl implements MarketDao{
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
	
}
