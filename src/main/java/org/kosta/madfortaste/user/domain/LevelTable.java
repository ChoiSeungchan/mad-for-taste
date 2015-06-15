package org.kosta.madfortaste.user.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class LevelTable {
	
	/**
	 * levelMap은 레벨-경험치 테이블이다.
	 * 스프링 컨테이너가 싱글턴 기반으로 객체를 생성해주기 떄문에
	 * static으로 선언해서 테이블을 한번만 만들도록 했다. (맞나모르겠다 ㅋㅋ) 
	 */
	private static Map<Integer, Integer> levelMap = new HashMap<Integer, Integer>();
	
	public LevelTable() {
		super();
		setLevelMap();
	}
	
	
	/**
	 * 멤버 객체를 매개변수로 받아
	 * 멤버 객체가 가지고 있는 필드인 누적경험치(exp)를 기반으로
	 * 또 다른 필드이자 멤버의 레벨정보를 담고 있는 LevelInfo class를 셋팅해준다.
	 * @param member
	 * @return
	 */
	public Member calculateLevelInfo(Member member){
		int memberExp = member.getExp();
		for(int i=1; i<100; i++) {
			if(memberExp < levelMap.get(i)) {	// 레벨 99 미만
				int level = i-1;
				int currentLevelExp = levelMap.get(level);
				int nextLevelExp = levelMap.get(level+1);
				int requiredExp = (int) (nextLevelExp - memberExp);
				int expDemandBlock = nextLevelExp - currentLevelExp;
				double expPercentage = (double)(memberExp - currentLevelExp) / (double)expDemandBlock * 100;
				expPercentage = Math.round(expPercentage * 100d) /100d;
				LevelInfo levelInfo = 
						new LevelInfo(level, currentLevelExp, requiredExp, nextLevelExp, expDemandBlock, expPercentage);
				member.setLevelInfo(levelInfo);
				break;
			} else if (memberExp >= levelMap.get(i) && memberExp <= 9999999) {	// 레벨 99일때
				int maxExp = 684901;
				LevelInfo levelInfo = 
						new LevelInfo(99, maxExp, maxExp, maxExp, 30000, 100);
				member.setLevelInfo(levelInfo);
			} else if (memberExp > 9999999) {
				LevelInfo levelInfo = 
						new LevelInfo(100, 9999999, 9999999, 9999999, 9999999, 100);
				member.setLevelInfo(levelInfo);
			}
		}
		return member;
	}
	
	public void setLevelMap() {
		int exp = 1;
		for (int level = 1; level < 100; level++) {
			
			if (level == 1) {

			} else if (level <= 10) {
				exp += 100;
			} else if (level <= 20) {
				exp += 200;
			} else if (level <= 30) {
				exp += 400;
			} else if (level <= 40) {
				exp += 800;
			} else if (level <= 50) {
				exp += 2000;
			} else if (level <= 60) {
				exp += 3000;
			} else if (level <= 70) {
				exp += 5000;
			} else if (level <= 80) {
				exp += 10000;
			} else if (level <= 90) {
				exp += 20000;
			} else if (level <= 100) {
				exp += 30000;
			} else {
				
			}
			levelMap.put(level, exp);
		}
		
	}
	
}
