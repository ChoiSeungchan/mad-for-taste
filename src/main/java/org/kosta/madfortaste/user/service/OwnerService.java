package org.kosta.madfortaste.user.service;

import org.kosta.madfortaste.user.domain.Owner;

public interface OwnerService {
	public Owner insertOwner(Owner owner);
	public Owner selectOwnerById(String id);
	public int deleteOwnerById(String id);
}
