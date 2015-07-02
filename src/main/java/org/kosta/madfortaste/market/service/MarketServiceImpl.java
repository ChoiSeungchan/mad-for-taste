package org.kosta.madfortaste.market.service;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.market.dao.MarketDao;
import org.kosta.madfortaste.market.domain.Inventory;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.domain.Purchase;
import org.kosta.madfortaste.market.exception.PurchaseException;
import org.kosta.madfortaste.user.dao.MemberDao;
import org.kosta.madfortaste.user.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MarketServiceImpl implements MarketService{
	
	@Autowired
	private MarketDao marketDao;
	
	@Autowired
	private MemberDao memberDao;

	@Resource(name="itemImg")
	private String path;
	
	@Override
	public int getTotalItemCount() {
		return marketDao.getTotalItemCount();
	}
	
	@Override
	public void registerItem(Item item, HttpServletRequest req) throws IllegalStateException, IOException {
		MultipartFile itemImg = item.getItemImg();
		String fileName = marketDao.getItemSequence()+"";
		String ext = itemImg.getOriginalFilename().substring(itemImg.getOriginalFilename().lastIndexOf(".")+1);
		item.setItemImgName(fileName + "." + ext);
		item = marketDao.insertItem(item);
		if(item.getItemNo()>0) registerItemImg(item, req);
	}

	@Override
	public int insertPurchase(String memberId, int itemNo, int purchaseAmount) {
		return marketDao.insertPurchase(memberId, itemNo, purchaseAmount);
	}

	@Override
	public Item selectItem(int itemNo) {
		return marketDao.selectItem(itemNo);
	}

	@Override
	public List<Item> getItemsByPaging(int currentPage) {
		int totalItemCount = marketDao.getTotalItemCount();
		Page page = new Page(totalItemCount);
		page.setPageSize(8);
		page.setCurrentPage(currentPage);
		List<Item> itemList = null;
		if(currentPage <= page.getPageCount()) {
			itemList = marketDao.getItemsByPaging(page);
		}
		return itemList;
	}

	@Override
	public void updateItem(Item item) {
		marketDao.updateItem(item);
	}

	@Override
	public void deleteItem(int itemNo) {
		marketDao.deleteItem(itemNo);
	}

	@Override
	public int getTotalPurchaseCount() {
		return marketDao.getTotalPurchaseCount();
	}

	@Override
	public List<Purchase> getPurchaseList(String memberId) {
		return marketDao.getPurchaseList(memberId);
	}

	@Override
	public List<Purchase> getPurchaseListByPaging(String memberId, Page page) {
		return marketDao.getPurchaseListByPaging(memberId, page);
	}
	
	@Transactional
	@Override
	public void itemPurchaseService(Inventory inven) throws PurchaseException {
		Item item = marketDao.selectItem(inven.getItemNo());
		int stock = item.getItemStock();
		int buyAmount = inven.getItemAmount();
		int totalPrice = buyAmount * item.getItemPrice();
		Member member = memberDao.selectMemberById(inven.getId()); 
		if(stock==0) throw new PurchaseException("재고가 없습니다.");
		if((stock - buyAmount)<0) throw new PurchaseException("재고가 부족합니다.");
		if(member.getPoint()<totalPrice) throw new PurchaseException("포인트가 부족합니다.");
		memberDao.downPoint(inven.getId(), totalPrice);
		item.setItemStock(stock - buyAmount);
		marketDao.updateItem(item);
		Inventory existInventory = marketDao.selectInventory(inven);
		if (existInventory!=null) {
			inven.setItemAmount(inven.getItemAmount()+existInventory.getItemAmount());
			marketDao.updateInventory(inven);
		} else {
			marketDao.insertInventory(inven);
		}
	}
	
	public Item registerItemImg(Item item, HttpServletRequest req) throws IllegalStateException, IOException {
		String realPath = new HttpServletRequestWrapper(req).getRealPath("/") + path;
		MultipartFile imgFile = item.getItemImg();
		if(imgFile.getSize()!=0) {
			// 확장자 추출
			String extension = imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf(".")+1);
			// 파일 업로드
			imgFile.transferTo(new File(realPath + item.getItemNo() + "." + extension));
			// 데이터베이스에 저장할 이미지 이름 파싱
			//item.setProfileImg(item.getItemNo()+ "." +extension);
			
			 /*
				프로필 사진이 java.png로 등록되어 있는데 java.jpg로 새로운 사진이 등록되면
			 	java.jpg는 등록되고 java.png를 삭제해준다.
			 */
			for (File file : new File(realPath).listFiles()) {
				if(file.isFile()) {
				String fileName = file.getName();
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
				String fileBody = fileName.substring(0, fileName.length() - fileExt.length() - 1);
				if(fileBody.equals(item.getItemNo()) && !fileExt.equals(extension)) file.delete();
				}
			}
		} else {
			for (File file : new File(realPath).listFiles()) {
				if(file.isFile()) {
					String fileName = file.getName();
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
					String fileBody = fileName.substring(0, fileName.length() - fileExt.length() - 1);
					if(fileBody.equals(item.getItemNo())){
						item.setItemImgName(fileBody + "." + fileExt);
						break;
					} else {
						item.setItemImgName("default.jpg");
					}
				}
			}
		}
		return item;
	}

}
