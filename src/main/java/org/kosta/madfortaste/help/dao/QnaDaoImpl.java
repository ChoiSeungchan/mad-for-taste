package org.kosta.madfortaste.help.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Qna;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDaoImpl implements QnaDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int totalQnaContentCount() {
		return sqlSessionTemplate.selectOne("qna.totalQnaContentCount");
	}
	
	@Override
	public int totalQnaInputContentCount(String input) {
		return sqlSessionTemplate.selectOne("qna.totalQnaInputContentCount",input);
	}

	@Override
	public List<Qna> loadQnaList(Page page) {
		List<Qna> list = sqlSessionTemplate.selectList("qna.loadQnaList", page);
		/*System.out.println("DAOImpl list : " + list);*/
		return list;
	}
	
	@Override
	public List<Qna> loadQnaListByUser(HashMap<String, Object> map,
			String searchSelect) {
		List<Qna> list =  sqlSessionTemplate.selectList("qna.loadQnaListByUser", map);
		return list;
	}
	@Override
	public List<Qna> loadQnaListByBoth(HashMap<String, Object> map,
			String searchSelect) {
		List<Qna> list = sqlSessionTemplate.selectList("qna.loadQnaListByBoth", map);
		return list;
	}

	@Override
	public Qna getQnaContents(String pageNo) {
		return sqlSessionTemplate.selectOne("qna.getQnaContents", pageNo);
	}

	@Override
	public int insertQna(Qna qna) {
		System.out.println(qna);
		int result =sqlSessionTemplate.insert("qna.insertQna", qna);
		System.out.println(qna);
		return result;
	}

	@Override
	public void updateQna(Qna qna) {
		sqlSessionTemplate.update("qna.updateQna", qna);

	}

	@Override
	public void deleteQna(String pageNo) {
		sqlSessionTemplate.delete("qna.deleteQna", pageNo);

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
		System.out.println("before="+qna);
		sqlSessionTemplate.insert("qna.insertRefContent", qna);
		System.out.println("after="+qna);
	}

	

}
