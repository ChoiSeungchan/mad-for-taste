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
	private OwnerDao dao;
	@Resource(name="uploadPath")
	private String path;
	
	@Override
	public Owner insertOwner(Owner owner) {	
		MultipartFile file=owner.getImgFile();
		String fileName=file.getOriginalFilename();
		owner.setProfileImg(fileName);
		try {
			file.transferTo(new File(path+owner.getOwnerId()+"_"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao.insertOwner(owner);
	}
	
}
