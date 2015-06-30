package org.kosta.madfortaste.taste.dao;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.taste.domain.TastyPlaceBoard;
import org.kosta.madfortaste.taste.domain.TastyPlaceMark;

public interface TastyPlaceDao {
	public int insertTastyPlace(TastyPlace tastyPlace);
	public TastyPlace selectTastyPlaceById(String id);
	public List<TastyPlace> selectTastyPlaceGetAllList(String id);
	public int deleteTastyPlace(String id);
	public int updateTastyPlace(TastyPlace tastyPlace);
	public int insertTastyPlaceMark(TastyPlaceMark tastyPlaceMark);
	public int selectTastyPlaceMarkByDoublePk(TastyPlaceMark tastyPlaceMark);
	public Map<String,String> selectTastyPlaceMarkTotalPrice(String brNo);
	public String selectTastyPlaceMarkAge20(String brNo);
	public String selectTastyPlaceMarkAge30(String brNo);
	public String selectTastyPlaceMarkAge40(String brNo);
	public int insertTastyPlaceReplyOwner(TastyPlaceBoard tastyPlaceBoard);
	public int insertTastyPlaceReplyMember(TastyPlaceBoard tastyPlaceBoard);
	public List<TastyPlaceBoard> selectTastyPlaceReplyMember(Map<String, String> map);
	public List<TastyPlaceBoard> selectTastyPlaceReplyOwner(Map<String, String> map);
	public String selectTastyPlacefindByBrNo(String id);
}
