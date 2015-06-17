package org.kosta.madfortaste.help.dao;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Notice;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDaoImpl implements NoticeDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<Notice> loadNoticeList(Page page) {
		List<Notice> list =sqlSessionTemplate.selectList("notice.loadNoticeList",page); 
		return list;
		
	}

	@Override
	public Notice getContents(String no) {
		return sqlSessionTemplate.selectOne("notice.getContents",no);
		
	}

	@Override
	public int totalContentCount() {
		return sqlSessionTemplate.selectOne("notice.totalContentCount");
	}

	@Override
	public int insert(Notice notice) {
		return sqlSessionTemplate.insert("notice.insert",notice);
	}

	@Override
	public void update(Notice notice) {
		sqlSessionTemplate.update("notice.update",notice);
		
	}

	@Override
	public void delete(String no) {
		sqlSessionTemplate.delete("notice.delete",no);
		
	}

	@Override
	public void updateViewCount(String articleNo) {
		sqlSessionTemplate.update("notice.updateViewCount", articleNo);
	}
	
	
	
	
	
	
}
