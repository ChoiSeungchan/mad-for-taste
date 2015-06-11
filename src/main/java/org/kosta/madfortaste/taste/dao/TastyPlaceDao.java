package org.kosta.madfortaste.taste.dao;

import org.kosta.madfortaste.taste.domain.TastyPlace;

public interface TastyPlaceDao {
	public int insertTastyPlace(TastyPlace tastyPlace);
	public TastyPlace selectTastyPlaceById(String id);
}
