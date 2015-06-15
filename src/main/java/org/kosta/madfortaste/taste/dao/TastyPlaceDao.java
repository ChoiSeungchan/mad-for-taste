package org.kosta.madfortaste.taste.dao;

import java.util.List;

import org.kosta.madfortaste.taste.domain.TastyPlace;

public interface TastyPlaceDao {
	public int insertTastyPlace(TastyPlace tastyPlace);
	public TastyPlace selectTastyPlaceById(String id);
	public List<TastyPlace> selectTastyPlaceGetAllList(String id);
	public int deleteTastyPlace(String id);
	public int updateTastyPlace(TastyPlace tastyPlace);
}
