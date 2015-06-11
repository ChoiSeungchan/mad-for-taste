package org.kosta.madfortaste.user.dao;

import java.security.acl.Owner;

import org.kosta.madfortaste.user.domain.LevelTable;
import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.domain.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private LevelTable levelTable;

	/**
	 * 아이디랑 패스워드만 가지고나오기 떄문에 다른 변수들은 null이다.	
	 */
	@Transactional
	@Override
	public User isExistUser(String userId) {
		User user = null;
		user = sqlSessionTemplate.selectOne("auth.findMember", userId);
		if(user==null)
		user = sqlSessionTemplate.selectOne("auth.findOwner", userId);
		return user;
	}

	@Override
	public Member getMemberInfo(String userId) {
		Member member = sqlSessionTemplate.selectOne("auth.getMemberInfo", userId);
		if(member!=null) levelTable.calculateLevelInfo(member);
		return member;
	}

	@Override
	public Owner getOwnerInfo(String userId) {
		return sqlSessionTemplate.selectOne("auth.getOwnerInfo", userId);
	}
}
