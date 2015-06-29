package org.kosta.madfortaste.market.dao;

import java.util.Map;

import org.kosta.madfortaste.market.domain.Item;

public interface MarketDao {
	public int insertItem(Item item);
	public int insertPurchase(Map<String, Object> map);
}
