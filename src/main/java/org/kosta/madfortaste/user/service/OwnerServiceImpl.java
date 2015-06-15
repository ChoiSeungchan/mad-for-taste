package org.kosta.madfortaste.user.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.kosta.madfortaste.user.dao.OwnerDao;
import org.kosta.madfortaste.user.domain.Owner;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OwnerServiceImpl implements OwnerService{
	@Inject
	private OwnerDao ownerDao;
	@Resource(name="ownerImg")
	private String path;
	
	@Override
	public Owner insertOwner(Owner owner,HttpServletRequest req) {	
		MultipartFile file=owner.getImgFile();
		String fileName=file.getOriginalFilename();
		String realPath=new HttpServletRequestWrapper(req).getRealPath("/");
		if(fileName.trim().length()==0)
			owner.setProfileImg("default.jpg");
		else{
			owner.setProfileImg(fileName);
			try {
				file.transferTo(new File(realPath+path+owner.getOwnerId()+"_"+fileName));
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

	@Override
	public void updateOwnerById(Owner owner,HttpServletRequest req) {
		MultipartFile file=owner.getImgFile();
		String fileName=file.getOriginalFilename();
		String realPath=new HttpServletRequestWrapper(req).getRealPath("/");
		if(fileName.trim().length()!=0){
			owner.setProfileImg(fileName);
			File []files=new File(realPath+path).listFiles();
			String filesName="";
			for(int i=0; i<files.length; i++){
				String []arr=files[i].getName().split("_");
				for(int j=0; j<arr.length; j++){
					if(j>0)
						break;
					filesName=arr[j];
				}
				if(filesName.equals(owner.getOwnerId())){
					if(!(files[i].toString().contains(owner.getProfileImg())))
						files[i].delete();
				}
			}
			try {
				file.transferTo(new File(realPath+path+owner.getOwnerId()+"_"+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			Owner owners=(Owner)req.getSession(false).getAttribute("owner");
			owner.setProfileImg(owners.getProfileImg());
		}
		String profileImg=owner.getProfileImg();
	    int startIndex=profileImg.lastIndexOf("_")+1;
	    owner.setProfileImg(profileImg.substring(startIndex));
		ownerDao.updateOwnerById(owner);
	}
	
}
