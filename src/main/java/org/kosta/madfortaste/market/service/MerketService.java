package org.kosta.madfortaste.market.service;

import java.util.Map;

import org.kosta.madfortaste.market.dao.MarketDao;
import org.kosta.madfortaste.market.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface MerketService {
	public int insertItem(Item item);
	public Object insertPurchase(Map<String, Object> map);
}
