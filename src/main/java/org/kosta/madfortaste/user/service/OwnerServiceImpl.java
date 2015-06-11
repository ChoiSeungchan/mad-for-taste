package org.kosta.madfortaste.user.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.kosta.madfortaste.user.dao.OwnerDao;
import org.kosta.madfortaste.user.domain.Owner;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OwnerServiceImpl implements OwnerService{
	@Inject
	private OwnerDao ownerDao;
	@Resource(name="uploadPath")
	private String path;
	
	@Override
	public Owner insertOwner(Owner owner) {	
		MultipartFile file=owner.getImgFile();
		String fileName=file.getOriginalFilename();
		if(fileName.trim().length()==0)
			owner.setProfileImg("default.jpg");
		else{
			owner.setProfileImg(fileName);
			try {
				file.transferTo(new File(path+owner.getOwnerId()+"_"+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ownerDao.insertOwner(owner);
	}

	@Override
	public Owner selectOwnerById(String id) {
		return ownerDao.selectOwnerById(id);
	}

	@Override
	public int deleteOwnerById(String id) {
		return ownerDao.deleteOwnerById(id);
	}
	
}
