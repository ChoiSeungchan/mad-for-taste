package org.kosta.madfortaste.taste.dao;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.taste.domain.TastyPlaceMark;
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
		return sqlSessionTemplate.selectOne("tastyPlace.selectTastyPlaceByNo",id);
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
	public int insertTastyPlaceMark(TastyPlaceMark tastyPlaceMark){
		return sqlSessionTemplate.insert("tastyPlace.insertTastyPlaceMark",tastyPlaceMark);
	}
	public int selectTastyPlaceMarkByDoublePk(TastyPlaceMark tastyPlaceMark){
		return sqlSessionTemplate.selectOne("tastyPlace.selectTastyPlaceMarkByDoublePk",tastyPlaceMark);
	}
	public Map<String,String> selectTastyPlaceMarkTotalPrice(){
		return sqlSessionTemplate.selectOne("tastyPlace.selectTastyPlaceMarkTotalPrice");
	}
	public String selectTastyPlaceMarkAge20(){
		return sqlSessionTemplate.selectOne("tastyPlace.selectTastyPlaceMarkAge20");
	}
	public String selectTastyPlaceMarkAge30(){
		return sqlSessionTemplate.selectOne("tastyPlace.selectTastyPlaceMarkAge30");
	}
	public String selectTastyPlaceMarkAge40(){
		return sqlSessionTemplate.selectOne("tastyPlace.selectTastyPlaceMarkAge40");
	}
}
