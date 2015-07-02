package org.kosta.madfortaste.taste.service;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.taste.domain.Restaurant;
import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.taste.domain.TastyPlaceBoard;
import org.kosta.madfortaste.taste.domain.TastyPlaceMark;

public interface TastyPlaceService {
	public int insertTastyPlace(TastyPlace tastyPlace);
	public TastyPlace selectTastyPlaceById(String id);
	public List<TastyPlace> selectTastyPlaceGetAllList(String id);
	public int deleteTastyPlace(String id);
	public void updateTastyPlace(TastyPlace tastyPlace);
	public int insertTastyPlaceMark(TastyPlaceMark tastyPlaceMark);
	public int selectTastyPlaceMarkByDoublePk(TastyPlaceMark tastyPlaceMark);
	public Map<String,String> selectTastyPlaceMarkTotalPrice(String brNo);
	public String selectTastyPlaceMarkAge20(String brNo);
	public String selectTastyPlaceMarkAge30(String brNo);
	public String selectTastyPlaceMarkAge40(String brNo);
	public int insertTastyPlaceReplyOwner(TastyPlaceBoard tastyPlaceBoard);
	public int insertTastyPlaceReplyMember(TastyPlaceBoard tastyPlaceBoard);
	public List<TastyPlaceBoard> selectTastyPlaceReplyMember(String viewCnt,String brNo);
	public List<TastyPlaceBoard> selectTastyPlaceReplyOwner(String viewCnt,String brNo);
	public String selectTastyPlacefindByBrNo(String id);
}
