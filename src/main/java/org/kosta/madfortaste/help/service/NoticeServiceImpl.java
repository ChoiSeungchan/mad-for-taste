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
		noticeDAO.updateViewCount(no);
		return noticeDAO.getContents(no);
	}

	@Override
	public int insert(Notice notice) {
		return noticeDAO.insert(notice);
	}

	@Override
	public void update(Notice notice) {
		 noticeDAO.update(notice);
	}

	@Override
	public void delete(String no) {
	     noticeDAO.delete(no);
	}

}
