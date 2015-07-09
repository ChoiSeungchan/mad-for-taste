package org.kosta.madfortaste.taste.dao;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.taste.domain.Restaurant;

public interface RestaurantDao {
	public void insertRestaurant(Restaurant restaurant);
	public List<String> selectSi();
	public List<String> selectGu(String si);
	public List<String> selectDong(Map<String, String> map);
	public List<String> selectRi(Map<String, String> map);
	public String SelectRestaurantByAddress(Map<String, String> map);
	public void upGood(int resNo);
	public void upBad(int resNo);
	public List<Restaurant> selectRestaurantNearByAddress(Map<String, String> map);
	public int selectRestaurantTotalCnt(Map<String, String> map);
	public Restaurant selectRestaurantByResNo(String string);
}
