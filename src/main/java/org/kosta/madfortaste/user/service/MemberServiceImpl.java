package org.kosta.madfortaste.user.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.user.dao.MemberDao;
import org.kosta.madfortaste.user.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	@Resource(name="memberImg")
	private String path;
	
	public Member registerMemberImg(Member member, HttpServletRequest req) throws IllegalStateException, IOException {
		String realPath = new HttpServletRequestWrapper(req).getRealPath("/") + path;
		MultipartFile imgFile = member.getImgFile();
		if(imgFile.getSize()!=0) {
			// 확장자 추출
			String extension = imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf(".")+1);
			// 파일 업로드
			imgFile.transferTo(new File(realPath + member.getId() + "." + extension));
			// 데이터베이스에 저장할 이미지 이름 파싱
			member.setProfileImg(member.getId()+ "." +extension);
			
			/*
			 *	프로필 사진이 java.png로 등록되어 있는데 java.jpg로 새로운 사진이 등록되면
			 *	java.jpg는 등록되고 java.png를 삭제해준다.
			 */
			for (File file : new File(realPath).listFiles()) {
				String fileName = file.getName();
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
				String fileBody = fileName.substring(0, fileName.length() - fileExt.length() - 1);
				if(fileBody.equals(member.getId()) && !fileExt.equals(extension)) file.delete();
			}
		} else {
			for (File file : new File(realPath).listFiles()) {
				String fileName = file.getName();
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
				String fileBody = fileName.substring(0, fileName.length() - fileExt.length() - 1);
				if(fileBody.equals(member.getId())){
					member.setProfileImg(fileBody + "." + fileExt);
					break;
				} else {
					member.setProfileImg("default.jpg");
				}
			}
		}
		return member;
	}

	@Override
	public Member insertMember(Member member, HttpServletRequest req) throws IllegalStateException, IOException {
		registerMemberImg(member, req);
		return memberDao.insertMember(member);
	}
	
	@Override
	public void updateMember(Member member, HttpServletRequest req) throws IllegalStateException, IOException {
		registerMemberImg(member, req);
		System.out.println(member);
		memberDao.updateMember(member);
	}
	
	@Override
	public Member selectMemberById(String id) {
		Member member = memberDao.selectMemberById(id);
		return member;
	}

	@Override
	public int selectTotalCount() {
		return memberDao.selectTotalCount();
	}

	@Override
	public List<Member> selectMemberList(int currentPage) {
		Page page = new Page(memberDao.selectTotalCount());
		page.setCurrentPage(currentPage);
		page.setPageSize(10);
		page.setPageGroupSize(5);
		return memberDao.selectMemberList(page);
	}

	@Override
	public void deleteMember(String id) {
		memberDao.deleteMember(id);
	}

	@Override
	public void upExp(String id, int acquiredExp) {
		memberDao.upExp(id, acquiredExp);
	}

	@Override
	public void upPoint(String id, int acquiredPoint) {
		memberDao.upPoint(id, acquiredPoint);
	}

	@Override
	public void downPoint(String id, int lostPoint) {
		memberDao.downPoint(id, lostPoint);
	}

}
