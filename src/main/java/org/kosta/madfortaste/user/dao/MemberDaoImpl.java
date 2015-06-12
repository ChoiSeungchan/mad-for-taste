package org.kosta.madfortaste.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.user.domain.LevelTable;
import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.exception.NotEnoughPointException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Resource
	LevelTable levelTable;
	
	@Resource(name="memberImg")
	private String memberImgPath;
	
	@Override
	public Member insertMember(Member member) {
		sqlSessionTemplate.insert("insertMember", member);
		return member;
	}

	@Override
	public Member selectMemberById(String id) {
		Member member = sqlSessionTemplate.selectOne("selectMemberById", id);
		if(member!=null) levelTable.calculateLevelInfo(member);
		member.setProfileImg(memberImgPath + member.getProfileImg());
		return member;
	}

	@Override
	public int selectTotalCount() {
		return sqlSessionTemplate.selectOne("selectTotalCount");
	}

	@Override
	public List<Member> selectMemberList(Page page) {
		List<Member> memberList = sqlSessionTemplate.selectList("selectMemberList", page);
		for (Member member : memberList) {
			if(member!=null) levelTable.calculateLevelInfo(member);
			member.setProfileImg(memberImgPath + member.getProfileImg());
		}
		return memberList;
	}

	@Override
	public void updateMember(Member member) {
		sqlSessionTemplate.update("updateMember",member);
	}

	@Override
	public void deleteMember(String id) {
		sqlSessionTemplate.delete("deleteMember",id);
	}

	@Override
	public void upExp(String id, int acquiredExp) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("exp", acquiredExp);
		sqlSessionTemplate.update("upExp", map);
	}

	@Override
	public void upPoint(String id, int acquiredPoint) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("point", acquiredPoint);
		sqlSessionTemplate.update("upPoint", map);
	}

	@Override
	public void downPoint(String id, int lostPoint) {
		int point =  this.selectMemberById(id).getPoint();
		if(point < lostPoint) throw new NotEnoughPointException("잔여포인트 : " + point + " , 감소포인트 : " + lostPoint);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("point", lostPoint);
		sqlSessionTemplate.update("downPoint", map);
	}
}
