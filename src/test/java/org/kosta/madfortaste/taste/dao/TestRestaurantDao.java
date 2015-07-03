package org.kosta.madfortaste.taste.dao;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.taste.domain.Restaurant;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestRestaurantDao {	
	@Autowired
	private RestaurantDao restaurantDao;
	private org.slf4j.Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 *  레스토랑 등록~
	 */
	@Test
	public void testInsertRestaurant(){
		Restaurant restaurant=new Restaurant("도미노피자", "서울특별시", "마포구", "상수동");
		String resNo=restaurant.getResNo();//입력값이 없으므로 null
		assertNull(resNo);//Success Case: null
		restaurantDao.insertRestaurant(restaurant);
		resNo=restaurant.getResNo();
		// ↓ 성공할시 mybatis에서 현재 시퀀스 반환하므로 null값이 올수 없다.
		assertNotNull(restaurant.getResNo());
		log.info(resNo);
	}
	
	/**
	 *  시군구 셀렉트 박스 가져오기(select문)
	 */
	@Test
	public void testSelectSi(){//시.도 검색
		List<String> si=null; 
		si=restaurantDao.selectSi();
		assertNotNull(si); //Success Case: DB접근에 성공하면 null값이 올수 없다.
		for(String data : si)
			log.info(data);  //목록 출력
	}
	
	@Test
	public void testSelectGu(){
		List<String> gu=null;
		String si="  인천광역시"; //웹에서 셀렉트 박스로 넘어올 시.도 의 할당값
		gu=restaurantDao.selectGu(si); //선택한 시.도 내부의 해당 시.군.구 출력
		for(String data : gu)
			log.info(data);
	}
}
