package org.kosta.madfortaste.taste.dao;

import java.util.List;

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
	public List<TastyPlace> selectTastyPlaceGetAllList(String id){
		return sqlSessionTemplate.selectList("tastyPlace.selectTastyPlaceGetAllList",id);
	}
	public int deleteTastyPlace(String id){
		return sqlSessionTemplate.delete("tastyPlace.deleteTastyPlace",id);
	}
	public int updateTastyPlace(TastyPlace tastyPlace){
		return sqlSessionTemplate.update("tastyPlace.updateTastyPlace",tastyPlace);
	}
}
