package org.kosta.madfortaste.market.dao;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.market.domain.Inventory;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.domain.Purchase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestMarketDao {

	@Autowired
	private MarketDao marketDao;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void testGetItemSequence() {
		int itemSeq = marketDao.getItemSequence();
		System.out.println(itemSeq);
	}
	
	/**
	 * 아이템을 등록하는 메소드
	 */
	@Transactional
	@Test
	public void testInsertItem() {//아이템 등록(PERCENT_SALE,FREE_SALE)
		Item item = new Item(20, 1, "불닭나라 무료 쿠폰", 5000, "FREE_SALE", 100, "[대박]불닭나라 공짜 쿠폰!","1.jpg");
		assertThat(item.getItemNo(), is(0));
		marketDao.insertItem(item);
		assertThat(item.getItemNo(), greaterThan(0));
		log.info(item.toString());
	}
	
	/**
	 * itemNo를 입력해 해당하는 Item을 찾아 리턴하는 메소드
	 */
	@Test
	public void testSelectItem() {
		int itemNo = 2;
		int totalCount = marketDao.getTotalItemCount();
		assertThat(totalCount, greaterThan(0)); // item table이 notEmpty 이면 통과
		Item item = marketDao.selectItem(itemNo);
		assertNotNull(item); // item을 잘 받아오면 통과
		log.info(item.toString());
	}
	
	/**
	 * 페이징 처리가 된 Item List를 리턴하는 메소드
	 */
	@Test
	public void testGetItemsByPaging() {
		int totalCount = marketDao.getTotalItemCount();
		assertThat(totalCount, greaterThan(0)); // item table이 notEmpty 이면 통과
		Page page = new Page(totalCount);
		page.setCurrentPage(3);
		page.setPageSize(6);
		System.out.println(page.preview());
		List<Item> itemList = marketDao.getItemsByPaging(page);
		assertThat(itemList.size(), greaterThan(0)); // 리턴된 list의 size가 0보다 크면 통과
		for (Item item : itemList) {
			log.info(item.toString());
		}
	}
	
	
	/**
	 * Item 객체를 인자로 넘겨서 Item을 업데이트(수정) 하는 메소드
	 */
	@Transactional
	@Test
	public void testUpdateItem() {
		int totalCount = marketDao.getTotalItemCount();
		assertThat(totalCount, greaterThan(0)); // item table이 notEmpty 이면 통과
		Page page = new Page(totalCount);
		List<Item> itemList = marketDao.getItemsByPaging(page);
		Item beforeItem = itemList.get(0); // 0번째 인덱스는 반드시 존재할 수 밖에 없다
		log.info("업데이트 전 : " + beforeItem.getItemPrice());
		int beforeItemNo = beforeItem.getItemNo();
		int beforeItemPrice = beforeItem.getItemPrice();
		beforeItem.setItemPrice(beforeItemPrice+123);
		marketDao.updateItem(beforeItem);
		Item afterItem = marketDao.selectItem(beforeItemNo);
		assertNotEquals(beforeItemPrice, afterItem.getItemPrice()); // 업데이트 전,후 값이 다르면 통과
		log.info("업데이트 후 : " + afterItem.getItemPrice());
	}
	
	/**
	 * itemNo를 인자로 넘겨서 해당하는 Item을 삭제하는 메소드
	 */
	@Transactional
	@Test
	public void testDeleteItem() {
		int totalCount = marketDao.getTotalItemCount();
		assertThat(totalCount, greaterThan(0)); // item table이 notEmpty 이면 통과
		Page page = new Page(totalCount);
		List<Item> itemList = marketDao.getItemsByPaging(page);
		Item beforeItem = itemList.get(0); // 0번째 인덱스는 반드시 존재할 수 밖에 없다
		marketDao.deleteItem(beforeItem.getItemNo());
		Item afterItem = marketDao.selectItem(beforeItem.getItemNo());
		assertNull(afterItem);
	}
	
	/**
	 * 구매(Purchase) 정보를 purchase table에 삽입하는 메소드
	 */
	@Test
	public void testInsertPurchase(){//구매행위 등록
		String memberId = "member";
		int itemNo = 1;
		int purchaseAmount = 1;
		int i = marketDao.insertPurchase(memberId, itemNo, purchaseAmount);
		assertThat(i, is(1));
	}
	
	/**
	 * memberId를 인자로 넘겨서 해당 memberId의 모든 Purchase List를 리턴하는 메소드
	 */
	@Test
	public void testGetPurchaseList() {
		assertThat(marketDao.getTotalPurchaseCount(), greaterThan(0));
		String memberId = "member";
		List<Purchase> purchaseList = marketDao.getPurchaseList(memberId);
		assertNotNull(purchaseList);
		if(purchaseList.size()!=0) {
			for (Purchase purchase : purchaseList) {
				log.info(purchase.toString());
			}
		}
	}
	
	/**
	 * memberId와 Page Bean을 인자로 넘겨서
	 * Page 설정대로 해당 memberId의 Purchase List를 리턴하는 메소드
	 */
	@Test
	public void testGetPurchaseListByPaging() {
		int totalPurchaseCount = marketDao.getTotalPurchaseCount();
		assertThat(totalPurchaseCount, greaterThan(0));
		Page page = new Page(totalPurchaseCount);
		page.setPageSize(1);
		page.setCurrentPage(2);
		String memberId = "member";
		List<Purchase> purchaseList = marketDao.getPurchaseListByPaging(memberId, page);
		assertNotNull(purchaseList);
		if(purchaseList.size()!=0) {
			for (Purchase purchase : purchaseList) {
				log.info(purchase.toString());
			}
		}
	}
	
	@Transactional
	@Test
	public void testInsertInventory() {
		Inventory inven = new Inventory("member", 1, 10);
		int i = marketDao.insertInventory(inven);
		assertThat(i, is(1));
	}
	
	@Test
	public void testSelectInventory() {
		Inventory inven = marketDao.selectInventory(new Inventory("member",1));
		System.out.println(inven);
	}
	
	@Test
	public void testSelectInventories() {
		int totalInvenCount = marketDao.getTotalInvenCount("member");
		assertThat(totalInvenCount, greaterThan(0));
		Page page = new Page(totalInvenCount);
		List<Inventory> invenList = marketDao.selectInventories("member", page);
		assertThat(invenList.size(), greaterThan(0));
		for (Inventory inventory : invenList) {
			log.info(inventory.toString());
		}
	}
	
	@Test
	public void testItemExistInInventory() {
		boolean isExist = marketDao.ItemExistInInventory(1,"member");
		System.out.println(isExist);
	}
	
	@Transactional
	@Test
	public void testUpdateInventory() {
		Inventory inven = marketDao.selectInventory(new Inventory("member",1));
		assertNotNull(inven);
		int beforeAmount = inven.getItemAmount();
		inven.setItemAmount(beforeAmount+10);
		marketDao.updateInventory(inven);
		inven = marketDao.selectInventory(new Inventory("member",1));
		int afterAmount = inven.getItemAmount();
		assertNotEquals(beforeAmount, afterAmount);
		log.info(inven.toString());
	}
	
}




