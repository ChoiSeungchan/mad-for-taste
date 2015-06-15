package org.kosta.madfortaste.help.service;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.dao.NoticeDao;
import org.kosta.madfortaste.help.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDao noticeDAO;
	
	@Override
	public List<Notice> loadNoticeList(String pageNo) {
		if(pageNo==null||pageNo==""){
			pageNo="1";
		}
		List<Notice> list = noticeDAO.loadNoticeList(new Page(Integer.parseInt(pageNo), 10, 5, noticeDAO.totalContentCount()));
		return list;
	}

	@Override
	public Notice getContents(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Notice notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String no) {
		// TODO Auto-generated method stub
		
	}

}
