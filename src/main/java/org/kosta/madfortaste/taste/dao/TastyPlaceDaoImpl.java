package org.kosta.madfortaste.taste.dao;

import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TastyPlaceDaoImpl implements TastyPlaceDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insertTastyPlace(TastyPlace tastyPlace){
		return sqlSessionTemplate.insert("tastyPlace.insertTastyPlace",tastyPlace);
	}
	public TastyPlace selectTastyPlaceById(String id){
		return sqlSessionTemplate.selectOne("tastyPlace.selectTastyPlaceById",id);
	}
}
