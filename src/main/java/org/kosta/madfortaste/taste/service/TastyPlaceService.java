package org.kosta.madfortaste.taste.service;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.taste.domain.TastyPlaceMark;

public interface TastyPlaceService {
	public int insertTastyPlace(TastyPlace tastyPlace);
	public TastyPlace selectTastyPlaceById(String id);
	public List<TastyPlace> selectTastyPlaceGetAllList(String id);
	public void deleteTastyPlace(String id);
	public void updateTastyPlace(TastyPlace tastyPlace);
	public void insertTastyPlaceMark(TastyPlaceMark tastyPlaceMark);
	public int selectTastyPlaceMarkByDoublePk(TastyPlaceMark tastyPlaceMark);
	public Map<String,String> selectTastyPlaceMarkTotalPrice();
	public String selectTastyPlaceMarkAge20();
	public String selectTastyPlaceMarkAge30();
	public String selectTastyPlaceMarkAge40();
}
