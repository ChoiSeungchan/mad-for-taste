package org.kosta.madfortaste.market.service;

import java.util.Map;

import org.kosta.madfortaste.market.dao.MarketDao;
import org.kosta.madfortaste.market.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MarketServiceImpl implements MerketService{
	@Autowired
	private MarketDao marketDao;
	
	@Override
	public int insertItem(Item item) {
		return marketDao.insertItem(item);
	}

	@Override
	public Object insertPurchase(Map<String, Object> map) {
		return marketDao.insertPurchase(map);
	}

}
