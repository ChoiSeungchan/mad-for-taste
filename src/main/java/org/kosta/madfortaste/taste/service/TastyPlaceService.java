package org.kosta.madfortaste.taste.service;

import java.util.List;

import org.kosta.madfortaste.taste.domain.TastyPlace;

public interface TastyPlaceService {
	public int insertTastyPlace(TastyPlace tastyPlace);
	public TastyPlace selectTastyPlaceById(String id);
	public List<TastyPlace> selectTastyPlaceGetAllList(String id);
	public void deleteTastyPlace(String id);
	public void updateTastyPlace(TastyPlace tastyPlace);
}
