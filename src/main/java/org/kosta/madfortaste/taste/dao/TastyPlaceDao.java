package org.kosta.madfortaste.taste.dao;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.taste.domain.TastyPlaceMark;

public interface TastyPlaceDao {
	public int insertTastyPlace(TastyPlace tastyPlace);
	public TastyPlace selectTastyPlaceById(String id);
	public List<TastyPlace> selectTastyPlaceGetAllList(String id);
	public int deleteTastyPlace(String id);
	public int updateTastyPlace(TastyPlace tastyPlace);
	public int insertTastyPlaceMark(TastyPlaceMark tastyPlaceMark);
	public int selectTastyPlaceMarkByDoublePk(TastyPlaceMark tastyPlaceMark);
	public Map<String,String> selectTastyPlaceMarkTotalPrice();
	public String selectTastyPlaceMarkAge20();
	public String selectTastyPlaceMarkAge30();
	public String selectTastyPlaceMarkAge40();
}
