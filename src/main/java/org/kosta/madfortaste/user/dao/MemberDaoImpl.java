package org.kosta.madfortaste.user.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.user.domain.LevelTable;
import org.kosta.madfortaste.user.domain.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Resource
	LevelTable levelTable;
	
	public void insertExpTable(Map<String, Integer> expInfo) {
		sqlSessionTemplate.insert("insertExpTable", expInfo);
	}

	public Member insertMember(Member member) {
		sqlSessionTemplate.insert("insertMember", member);
		return member;
	}

	public Member selectMemberById(String id) {
		Member member = sqlSessionTemplate.selectOne("selectMemberById", id);
		levelTable.calculateLevelInfo(member);
		return member;
	}

	public int selectTotalCount() {
		return sqlSessionTemplate.selectOne("selectTotalCount");
	}

	public List<Member> selectMemberList(Page page) {
		List<Member> memberList = sqlSessionTemplate.selectList("selectMemberList", page);
		for (Member member : memberList) {
			levelTable.calculateLevelInfo(member);
		}
		return memberList;
	}

	public void updateMember(Member member) {
		sqlSessionTemplate.update("updateMember",member);
	}

	public void deleteMember(String id) {
		sqlSessionTemplate.delete("deleteMember",id);
	}
}
