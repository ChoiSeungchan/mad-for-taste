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
	public Owner selectOwnerById(String id){
		return sqlSessionTemplate.selectOne("owner.selectOwnerById",id);
	}
	public int deleteOwnerById(String id){
		return sqlSessionTemplate.delete("owner.deleteOwnerById",id);
	}
	public int updateOwnerById(Owner owner){
		return sqlSessionTemplate.update("owner.updateOwnerById",owner);
	}
}
