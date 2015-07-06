package org.kosta.madfortaste.taste.dao;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.taste.domain.Restaurant;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class RestaurantDaoImpl implements RestaurantDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertRestaurant(Restaurant restaurant) {
		sqlSessionTemplate.insert("tastyPlace.insertRestaurant",restaurant);
	}

	@Override
	public List<String> selectSi() {
		return sqlSessionTemplate.selectList("tastyPlace.selectSi");
	}

	@Override
	public List<String> selectGu(String si) {
		return sqlSessionTemplate.selectList("tastyPlace.selectGu",si);
	}

	@Override
	public List<String> selectDong(Map<String, String> map) {
		return sqlSessionTemplate.selectList("tastyPlace.selectDong",map);
	}

	@Override
	public List<String> selectRi(Map<String, String> map) {
		return sqlSessionTemplate.selectList("tastyPlace.selectRi",map);
	}

	@Override
	public String SelectRestaurantByAddress(Map<String, String> map) {
		return sqlSessionTemplate.selectOne("tastyPlace.SelectRestaurantByAddress",map);
	}

	@Override
	public void upGood(int resNo) {
		sqlSessionTemplate.update("tastyPlace.upGood", resNo);
	}

	@Override
	public void upBad(int resNo) {
		sqlSessionTemplate.update("tastyPlace.upBad", resNo);
	}
}
