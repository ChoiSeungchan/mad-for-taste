package org.kosta.madfortaste.help.service;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Notice;

public interface NoticeService {
	public List<Notice> loadNoticeList(Page page);
	public int totalContentCount();
	public Notice getContents(String no);
	public int insert(Notice notice);
	public void update(Notice notice);
	public void delete(String no);
	public Notice noCountGetContents(String no);
}
