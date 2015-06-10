package org.kosta.madfortaste.user.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.kosta.madfortaste.user.dao.OwnerDao;
import org.kosta.madfortaste.user.domain.Owner;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService{
	@Inject
	private OwnerDao dao;

	@Override
	public Owner insertOwner(Owner owner) {
		return dao.insertOwner(owner);
	}
	
}
