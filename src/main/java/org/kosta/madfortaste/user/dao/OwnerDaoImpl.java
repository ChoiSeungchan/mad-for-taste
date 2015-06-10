package org.kosta.madfortaste.user.dao;

import org.kosta.madfortaste.user.domain.Owner;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerDaoImpl implements OwnerDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public Owner insertOwner(Owner owner){
		sqlSessionTemplate.insert("owner.insertOwner",owner);
		return owner;
	}
}
