package org.kosta.madfortaste.taste.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.kosta.madfortaste.taste.dao.RestaurantDao;
import org.kosta.madfortaste.taste.domain.Restaurant;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Inject
	private RestaurantDao restaurantDao;

	@Override
	public List<String> selectSi() {
		return restaurantDao.selectSi();
	}

	@Override
	public List<String> selectGu(String si) {
		return restaurantDao.selectGu(si);
	}

	@Override
	public List<String> selectDong(Map<String, String> map) {
		return restaurantDao.selectDong(map);
	}

	@Override
	public List<String> selectRi(Map<String, String> map) {
		return restaurantDao.selectRi(map);
	}

	@Override
	public String SelectRestaurantByAddress(Map<String, String> map) {
		return restaurantDao.SelectRestaurantByAddress(map);
	}

	@Override
	public List<Restaurant> selectRestaurantNearByAddress(Map<String, String> map) {
		return restaurantDao.selectRestaurantNearByAddress(map);
	}

	@Override
	public int selectRestaurantTotalCnt(Map<String, String> map) {
		return restaurantDao.selectRestaurantTotalCnt(map);
	}

	@Override
	public Restaurant selectRestaurantByResNo(String string) {
		return restaurantDao.selectRestaurantByResNo(string);
	}
}
