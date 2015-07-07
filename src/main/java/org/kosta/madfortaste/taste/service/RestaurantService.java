package org.kosta.madfortaste.taste.service;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.taste.domain.Restaurant;

public interface RestaurantService {
	public List<String> selectSi();
	public List<String> selectGu(String si);
	public List<String> selectDong(Map<String, String> map);
	public List<String> selectRi(Map<String, String> map);
	public String SelectRestaurantByAddress(Map<String, String> map);
	public List<Restaurant> selectRestaurantNearByAddress(Map<String, String> map);
}