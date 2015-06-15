package org.kosta.madfortaste.help.dao;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Notice;

public interface NoticeDao {
	public int totalContentCount();
	public List<Notice> loadNoticeList(Page pageNo);
	public Notice getContents(String pageNo);
	public int insert(Notice notice);//잘되면 1 안되면 0
	public void update(Notice notice);
	public void delete(String pageNo);
	
}
