package org.kosta.madfortaste.taste.service;

import javax.inject.Inject;

import org.kosta.madfortaste.taste.dao.TastyPlaceDao;
import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.springframework.stereotype.Service;
@Service
public class TastyPlaceServiceImpl implements TastyPlaceService {
	@Inject
	private TastyPlaceDao tastyPlaceDao;
	@Override
	public int insertTastyPlace(TastyPlace tastyPlace) {
		return tastyPlaceDao.insertTastyPlace(tastyPlace);
	}

}
