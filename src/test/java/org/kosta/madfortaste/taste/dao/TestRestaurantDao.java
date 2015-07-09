package org.kosta.madfortaste.taste.dao;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Restaurant restaurant=new Restaurant("파파이스", "  서울특별시", "  강남구", "  대치동");
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
	public void testSelectGu(){//구 검색
		List<String> gu=null;
		String si="  인천광역시"; //웹에서 셀렉트 박스로 넘어올 시.도 의 할당값
		gu=restaurantDao.selectGu(si); //선택한 시.도 내부의 해당 시.군.구 출력
		for(String data : gu)
			log.info(data);
	}
	
	@Test
	public void testSelectDong(){//읍.면.동 검색
		List<String> dong=null;
		Map<String, String> map=new HashMap<String, String>();
		String si="  인천광역시";//웹에서 셀렉트 박스로 넘어올 시.도의 할당값
		String gu="  중구";//웹에서 셀렉트 박스로 넘어올 시.군.구의 할당값
		map.put("si", si);
		map.put("gu", gu);	//마이바티스 매개변수 전달을 위한 map 활용
		dong=restaurantDao.selectDong(map);
		assertNotNull(dong);//Success Case: null이 아니면 통과
		for(String data : dong)
			log.info(data);
	}
	
	@Test
	public void testSelectRi(){// 리 검색
		List<String> ri=null;
		Map<String, String> map=new HashMap<String, String>();
		String si="  대구광역시";
		String gu="  달성군";
		String dong="  유가면";
		map.put("si", si);
		map.put("gu", gu);
		map.put("dong", dong);
		ri=restaurantDao.selectRi(map);
		assertNotNull(ri); //Success Case: null이 아니면 통과
		for(String data : ri)
			log.info(data);
	}
	
	/**
	 *  해당 주소의 레스토랑 존재 여부 검색
	 */
	@Test
	public void testSelectRestaurantByAddress(){
		String resNo=null;
		Map<String, String> map=new HashMap<String, String>();
		map.put("si", "  대구광역시");
		map.put("gu", "  달성군");
		map.put("dong", "  유가면");
		map.put("name", "미스터피자");
		resNo=restaurantDao.SelectRestaurantByAddress(map);
		assertNull(resNo); //Success Case: null이어야 통과(중복되면 안되므로)
		log.info(resNo);
	}
	
	/**
	 * 레스토랑 pk 검색
	 */
	@Test
	public void testSelectRestaurantByResNo(){
		Restaurant restaurant=null;
		restaurant=restaurantDao.selectRestaurantByResNo("60");
		assertNotNull(restaurant);	//Success Case: null이 아니면 통과
		System.out.println(restaurant);
	}
}
