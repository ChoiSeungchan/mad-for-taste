package org.kosta.madfortaste.help.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.dao.QnaDao;
import org.kosta.madfortaste.help.domain.Qna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QnaServiceImpl implements QnaService {
	@Autowired
	private QnaDao qnaDao;

	public HashMap<String, Object> loadQnaService(String pageNo,
			String searchSelect, String input) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Qna> qnaList = null;
		Page qnaPageInfo = null;
		if (searchSelect == null) {
			searchSelect = "";
		}
		if (pageNo == null || pageNo == "") {
			pageNo = "1";
		}
		if (input == null || input == "") {
			input = "";
		}

		if (searchSelect.equals("0") || searchSelect.equals("1")) {
			qnaPageInfo = new Page(qnaDao.totalQnaInputContentCount(input));
			qnaPageInfo.setCurrentPage(Integer.parseInt(pageNo));
			map.put("page", qnaPageInfo);
			map.put("input", input);
			if(searchSelect.equals("0")){
				qnaList = qnaDao.loadQnaListByUser(map, searchSelect);
				map.put("qnaList", qnaList);
			}else{
				qnaList = qnaDao.loadQnaListByBoth(map, searchSelect);
				map.put("qnaList", qnaList);
			}
			
		} else {
			qnaPageInfo = new Page(qnaDao.totalQnaContentCount());
			qnaPageInfo.setCurrentPage(Integer.parseInt(pageNo));
			map.put("page", qnaPageInfo);
			map.put("input", input);
			qnaList = qnaDao.loadQnaList(qnaPageInfo);
			map.put("qnaList", qnaList);
		}
		

		return map;
	}

	@Override
	public Qna getQnaContents(String no) {
		qnaDao.updateViewCountQna(no);
		return qnaDao.getQnaContents(no);
	}

	@Override
	public int insertQna(Qna qna) {
		return qnaDao.insertQna(qna);
	}

	@Override
	public void updateQna(Qna qna) {
		qnaDao.updateQna(qna);

	}

	@Override
	public void deleteQna(String no) {
		qnaDao.deleteQna(no);
	}

	@Override
	public Qna noCountGetContentsQna(String no) {
		return qnaDao.getQnaContents(no);
	}

	@Transactional
	@Override
	public void reply(Qna qna) {
		int ref = qna.getRef();
		int restep = qna.getRestep();
		int relevel = qna.getRelevel();
		qnaDao.updateRestep(ref, restep);
		// update 처리 후
		// 원본 글의 것보다 restep과 relevel이 1씩 커야 하므로
		// 입력 전에 restep값 과 relevel의 값을 1씩 증가하여 insert시킨다.
		qna.setRestep(restep + 1);
		qna.setRelevel(relevel + 1);
		qnaDao.insertRefContent(qna);// 답변글 입력
	}

	

}
