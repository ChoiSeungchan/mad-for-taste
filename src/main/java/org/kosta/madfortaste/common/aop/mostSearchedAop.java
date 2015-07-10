package org.kosta.madfortaste.common.aop;


import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.kosta.madfortaste.taste.service.TasteBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class mostSearchedAop {
	@Autowired
	private TasteBoardService tasteBoardService;
	private Logger log=LoggerFactory.getLogger(getClass());
	
	@Around("execution(public * org.kosta.madfortaste.taste.dao.TasteBoardDaoImpl.*ApplicationPaging(..)))")
	public Object mostSearched(ProceedingJoinPoint pJoinPoint) throws Throwable{
	    Map<String, String> map=null;
		List<String> list=null;
		String searchName=null;
		Object [] obj=pJoinPoint.getArgs();
	    for(Object o : obj)
	    	map=(Map<String, String>)o;
	    String searchVal=map.get("title");
	    if(searchVal==null){
	    	searchVal=map.get("name");
	    	list=tasteBoardService.selectRestaurantByWriter(searchVal);
	    }else
	    	list=tasteBoardService.selectRestaurantByTitle(searchVal);
		String name="";
		String maxCountName="";	//게시글이 가장 많이 참조하는 맛집 이름
		if(list.size()!=0){
			int currCnt=0;		//현재 가게의 총 참조 수
			int maxCnt=0;	//지금까지 최고 참조 대상 수
			for(String str : list){
				name=str;
				currCnt=0;
				for(String str2 : list){	
					if(name.equals(str2))
						currCnt++;
				}
				if(currCnt>maxCnt){
					maxCnt=currCnt;
					maxCountName=str;
				}
			}
			System.out.println(list);
			System.out.println(maxCountName);
			searchName=tasteBoardService.selectSearchValue(maxCountName);
			if(searchName==null)
				tasteBoardService.insertSearchValue(maxCountName);
			else
				tasteBoardService.updateSearchValue(maxCountName);
			}
			return pJoinPoint.proceed();
	}
}
