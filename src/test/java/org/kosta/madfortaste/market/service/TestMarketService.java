package org.kosta.madfortaste.market.service;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.exception.ExceedsMaximumException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestMarketService {
	@Resource
	private MerketService merketService;
	
	@Test
	public void testinsertItem(){
		assertEquals(1, merketService.insertItem(new Item(500, 10, "중국집 할인 쿠폰", 3000, "sale", 20, "중국집 20% 할인 쿠폰 이에요!")));
	}
	
	@Test
	public void testInsertPurchase(){//구매행위 등록
		Map<String, Object> map=new HashMap<String, Object>();
		int maxAmountAvailable=10;//웹에서 넘어올 해당 아이템에 대한 최대구매 수치
		int purchaseAmount=11;//구매수량
		try{
			if(purchaseAmount>maxAmountAvailable)
				throw new ExceedsMaximumException("현재 아이템 최고 구매수량을 초과하였으므로 구매 하실 수 없습니다");
			map.put("purchaseAmount", purchaseAmount);
			map.put("id", "member");
			map.put("itemNo", "2");		
			assertEquals(1, merketService.insertPurchase(map));
		} catch (ExceedsMaximumException e) {
				System.out.println(e.getMessage());
		}
	}
}
