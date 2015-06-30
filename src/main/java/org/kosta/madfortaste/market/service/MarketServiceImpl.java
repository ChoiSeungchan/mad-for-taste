package org.kosta.madfortaste.market.service;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.market.dao.MarketDao;
import org.kosta.madfortaste.market.domain.Item;
import org.kosta.madfortaste.market.domain.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketServiceImpl implements MerketService{
	
	@Autowired
	private MarketDao marketDao;

	@Override
	public List<Item> marketService(String currPage) {
		String curPage=currPage;
		Page page=new Page(marketDao.getTotalItemCount());
		page.setPageSize(6);
		if(curPage==null)
			curPage="1";
		page.setCurrentPage(Integer.parseInt(curPage));
		return marketDao.getItemsByPaging(page);
	}

	@Override
	public Item findItemByNo(String no) {
		return marketDao.selectItem(Integer.parseInt(no));
	}

}
