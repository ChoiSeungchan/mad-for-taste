package org.kosta.madfortaste.taste.dao;

import java.util.List;

import org.kosta.madfortaste.taste.domain.Restaurant;

public interface RestaurantDao {
	public void insertRestaurant(Restaurant restaurant);
	public List<String> selectSi();
	public List<String> selectGu(String si);
}
