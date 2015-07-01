package org.kosta.madfortaste.market.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.market.dao.MarketDao;
import org.kosta.madfortaste.market.domain.Inventory;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.exception.ExceedsMaximumException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestMarketService {
	
	@Autowired
	private MarketService marketService;
	
	@Autowired
	private MarketDao marketDao;
	
	@Test
	public void testItemPurchaseService() {
		/*
		 * 아이템을 구매했을때, 한 번도 구매한 적이 없는 아이템이라면
		 * Inventory에 들어가야되고, 이미 인벤토리에 존재하는 아이템이라면,
		 * 수량만 올라가야 한다. 
		 */
		Inventory inven = new Inventory("member", 3, 1);
		marketService.itemPurchaseService(inven);
		inven = marketDao.selectInventory(inven);
		List<Inventory> invenList = marketDao.selectInventories("member", new Page(marketDao.getTotalInvenCount("member")));
		for (Inventory inventory : invenList) {
			System.out.println(inventory);
		}
	}
}
