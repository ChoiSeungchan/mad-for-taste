package org.kosta.madfortaste.market.service;

import java.util.List;

import org.kosta.madfortaste.market.domain.Item;


public interface MerketService {
	public List<Item> marketService(String currPage);
	public Item findItemByNo(String no);
}
