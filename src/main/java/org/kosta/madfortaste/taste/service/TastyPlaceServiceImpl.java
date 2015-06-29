package org.kosta.madfortaste.taste.service;

import java.util.HashMap;
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
	public Map<String, String> selectTastyPlaceMarkTotalPrice(String brNo) {
		return tastyPlaceDao.selectTastyPlaceMarkTotalPrice(brNo);
	}
	@Override
	public String selectTastyPlaceMarkAge20(String brNo) {
		return tastyPlaceDao.selectTastyPlaceMarkAge20(brNo);
	}
	@Override
	public String selectTastyPlaceMarkAge30(String brNo) {
		return tastyPlaceDao.selectTastyPlaceMarkAge30(brNo);
	}
	@Override
	public String selectTastyPlaceMarkAge40(String brNo) {
		return tastyPlaceDao.selectTastyPlaceMarkAge40(brNo);
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
	public List<TastyPlaceBoard> selectTastyPlaceReplyMember(String viewCnt,String brNo) {
		Map<String, String>map =new HashMap<String, String>();
		map.put("cnt", viewCnt);map.put("brno", brNo);
		return tastyPlaceDao.selectTastyPlaceReplyMember(map);
	}
	@Override
	public List<TastyPlaceBoard> selectTastyPlaceReplyOwner(String viewCnt,String brNo) {
		Map<String, String>map =new HashMap<String, String>();
		map.put("cnt", viewCnt);map.put("brno", brNo);
		return tastyPlaceDao.selectTastyPlaceReplyOwner(map);
	}
	@Override
	public String selectTastyPlacefindByBrNo(String id) {
		return tastyPlaceDao.selectTastyPlacefindByBrNo(id);
	}

}
