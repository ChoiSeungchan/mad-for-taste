package org.kosta.madfortaste.taste.service;

import java.util.List;

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
	@Override
	public TastyPlace selectTastyPlaceById(String id) {
		return tastyPlaceDao.selectTastyPlaceById(id);
	}
	@Override
	public List<TastyPlace> selectTastyPlaceGetAllList(String id) {
		return tastyPlaceDao.selectTastyPlaceGetAllList(id);
	}
	@Override
	public void deleteTastyPlace(String id) {
		tastyPlaceDao.deleteTastyPlace(id);
	}
	@Override
	public void updateTastyPlace(TastyPlace tastyPlace) {
		tastyPlaceDao.updateTastyPlace(tastyPlace);
	}

}
