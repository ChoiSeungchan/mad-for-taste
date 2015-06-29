package org.kosta.madfortaste.market.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.domain.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestMarketDao {

	@Autowired
	private MarketDao marketDao;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testInsertItem() {//아이템 등록
		assertEquals(1, marketDao.insertItem(new Item(500, 10, "중국집 할인 쿠폰", 3000, "sale", 20, "중국집 20% 할인 쿠폰 이에요!")));	
	}
	
	@Test
	public void testInsertPurchase(){//구매행위 등록
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("purchaseAmount", "1");
		map.put("id", "member");
		map.put("itemNo", "2");
		assertEquals(1, marketDao.insertPurchase(map));
	}

}
