package org.kosta.madfortaste.user.dao;

import org.kosta.madfortaste.user.domain.Owner;

public interface OwnerDao {
	public Owner insertOwner(Owner owner);
	public Owner selectOwnerById(String id);
	public int deleteOwnerById(String id);
	public int updateOwnerById(Owner owner);
}
