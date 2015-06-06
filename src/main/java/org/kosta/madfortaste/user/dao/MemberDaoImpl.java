package org.kosta.madfortaste.user.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
}
