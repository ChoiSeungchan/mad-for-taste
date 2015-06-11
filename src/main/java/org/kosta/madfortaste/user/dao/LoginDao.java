package org.kosta.madfortaste.user.dao;


import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.domain.Owner;
import org.kosta.madfortaste.user.domain.User;

public interface LoginDao {

	public User isExistUser(String userId);

	public Member getMemberInfo(String userId);

	public Owner getOwnerInfo(String userId);

}
