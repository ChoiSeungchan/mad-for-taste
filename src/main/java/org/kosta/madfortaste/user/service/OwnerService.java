package org.kosta.madfortaste.user.service;

import javax.servlet.http.HttpServletRequest;

import org.kosta.madfortaste.user.domain.Owner;

public interface OwnerService {
	public Owner insertOwner(Owner owner,HttpServletRequest req);
	public Owner selectOwnerById(String id);
	public int deleteOwnerById(String id);
	public void updateOwnerById(Owner owner,HttpServletRequest req);
}
