package org.kosta.madfortaste.taste.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.kosta.madfortaste.taste.dao.TastyPlaceDao;
import org.kosta.madfortaste.taste.domain.TastyPlace;
import org.kosta.madfortaste.taste.domain.TastyPlaceBoard;
import org.kosta.madfortaste.taste.domain.TastyPlaceMark;
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
	@Override
	public void insertTastyPlaceMark(TastyPlaceMark tastyPlaceMark) {
		tastyPlaceDao.insertTastyPlaceMark(tastyPlaceMark);
	}
	@Override
	public int selectTastyPlaceMarkByDoublePk(TastyPlaceMark tastyPlaceMark) {
		return tastyPlaceDao.selectTastyPlaceMarkByDoublePk(tastyPlaceMark);
	}
	@Override
	public Map<String, String> selectTastyPlaceMarkTotalPrice() {
		return tastyPlaceDao.selectTastyPlaceMarkTotalPrice();
	}
	@Override
	public String selectTastyPlaceMarkAge20() {
		return tastyPlaceDao.selectTastyPlaceMarkAge20();
	}
	@Override
	public String selectTastyPlaceMarkAge30() {
		return tastyPlaceDao.selectTastyPlaceMarkAge30();
	}
	@Override
	public String selectTastyPlaceMarkAge40() {
		return tastyPlaceDao.selectTastyPlaceMarkAge40();
	}
	@Override
	public int insertTastyPlaceReplyOwner(TastyPlaceBoard tastyPlaceBoard) {
		return tastyPlaceDao.insertTastyPlaceReplyOwner(tastyPlaceBoard);
	}
	@Override
	public int insertTastyPlaceReplyMember(TastyPlaceBoard tastyPlaceBoard) {
		return tastyPlaceDao.insertTastyPlaceReplyMember(tastyPlaceBoard);
	}
	@Override
	public List<TastyPlaceBoard> selectTastyPlaceReplyMember(String viewCnt) {
		return tastyPlaceDao.selectTastyPlaceReplyMember(viewCnt);
	}
	@Override
	public List<TastyPlaceBoard> selectTastyPlaceReplyOwner(String viewCnt) {
		return tastyPlaceDao.selectTastyPlaceReplyOwner(viewCnt);
	}

}
