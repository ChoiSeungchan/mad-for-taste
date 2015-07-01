package org.kosta.madfortaste.taste.dao;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.taste.domain.Restaurant;
import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.taste.domain.TastyPlaceBoard;
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
	public Map<String,String> selectTastyPlaceMarkTotalPrice(String brNo){
		return sqlSessionTemplate.selectOne("tastyPlace.selectTastyPlaceMarkTotalPrice",brNo);
	}
	public String selectTastyPlaceMarkAge20(String brNo){
		return sqlSessionTemplate.selectOne("tastyPlace.selectTastyPlaceMarkAge20",brNo);
	}
	public String selectTastyPlaceMarkAge30(String brNo){
		return sqlSessionTemplate.selectOne("tastyPlace.selectTastyPlaceMarkAge30",brNo);
	}
	public String selectTastyPlaceMarkAge40(String brNo){
		return sqlSessionTemplate.selectOne("tastyPlace.selectTastyPlaceMarkAge40",brNo);
	}
	public int insertTastyPlaceReplyOwner(TastyPlaceBoard tastyPlaceBoard){
		return sqlSessionTemplate.insert("tastyPlace.insertTastyPlaceReplyOwner",tastyPlaceBoard);
	}
	public int insertTastyPlaceReplyMember(TastyPlaceBoard tastyPlaceBoard){
		return sqlSessionTemplate.insert("tastyPlace.insertTastyPlaceReplyMember",tastyPlaceBoard);
	}
	public List<TastyPlaceBoard> selectTastyPlaceReplyMember(Map<String, String> map){
		return sqlSessionTemplate.selectList("tastyPlace.selectTastyPlaceReplyMember",map);
	}
	public List<TastyPlaceBoard> selectTastyPlaceReplyOwner(Map<String, String> map){
		return sqlSessionTemplate.selectList("tastyPlace.selectTastyPlaceReplyOwner",map);
	}
	public String selectTastyPlacefindByBrNo(String id){
		return sqlSessionTemplate.selectOne("tastyPlace.selectTastyPlacefindByBrNo",id);
	}
	@Override
	public void insertRestaurant(Restaurant restaurant) {
		sqlSessionTemplate.insert("tastyPlace.insertRestaurant",restaurant);
	}
	@Override
	public List<String> selectRestaurantByAddrDo() {
		return sqlSessionTemplate.selectList("tastyPlace.selectRestaurantByAddrDo");
	}
	@Override
	public List<String> selectRestaurantByAddrSi(String addrDo) {
		return sqlSessionTemplate.selectList("tastyPlace.selectRestaurantByAddrSi",addrDo);
	}
}
