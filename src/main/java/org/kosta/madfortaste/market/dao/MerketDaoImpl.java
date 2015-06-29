package org.kosta.madfortaste.market.dao;

import java.util.Map;

import javax.inject.Inject;

import org.kosta.madfortaste.market.domain.Item;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MerketDaoImpl implements MarketDao{
	@Inject
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertItem(Item item) {
		return sqlSessionTemplate.insert("market.insertItem",item);
	}

	@Override
	public int insertPurchase(Map<String, Object> map) {
		return sqlSessionTemplate.insert("market.insertPurchase",map);
	}
}
