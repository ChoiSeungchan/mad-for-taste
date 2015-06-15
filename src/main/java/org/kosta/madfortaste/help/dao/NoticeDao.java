package org.kosta.madfortaste.help.dao;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Notice;

public interface NoticeDao {
	public int totalContentCount();
	public List<Notice> loadNoticeList(Page page);
	public Notice getContents(String no);
}
