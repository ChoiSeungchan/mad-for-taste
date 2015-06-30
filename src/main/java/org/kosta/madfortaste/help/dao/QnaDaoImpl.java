package org.kosta.madfortaste.help.dao;

import java.util.HashMap;
import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Qna;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class QnaDaoImpl implements QnaDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int totalQnaContentCount() {
		return sqlSessionTemplate.selectOne("qna.totalQnaContentCount");
	}

	@Override
	public List<Qna> loadQnaList(Page page) {
		List<Qna> list = sqlSessionTemplate.selectList("qna.loadQnaList",page);
		System.out.println("DAOImpl list : "+ list);
		return list;
	}

	@Override
	public Qna getQnaContents(String pageNo) {
		return sqlSessionTemplate.selectOne("qna.getQnaContents",pageNo);
	}

	@Override
	public int insertQna(Qna qna) {
		return sqlSessionTemplate.insert("qna.insertQna",qna);
	}

	@Override
	public void updateQna(Qna qna) {
		sqlSessionTemplate.update("qna.updateQna",qna);
		
	}

	@Override
	public void deleteQna(String pageNo) {
		sqlSessionTemplate.delete("qna.deleteQna",pageNo);
		
	}

	@Override
	public void updateViewCountQna(String articleNo) {
		sqlSessionTemplate.update("qna.updateViewCountQna", articleNo);
	}

	@Override
	public void updateRestep(int ref, int restep) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("ref", ref);
		map.put("restep", restep);
		sqlSessionTemplate.update("qna.updateRestep", map);		
	}

	@Override
	public void insertRefContent(Qna qna) {
		sqlSessionTemplate.insert("qna.insertRefContent",qna);
	}

}
