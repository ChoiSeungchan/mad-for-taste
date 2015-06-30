package org.kosta.madfortaste.help.service;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.dao.QnaDao;
import org.kosta.madfortaste.help.domain.Qna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class QnaServiceImpl implements QnaService{
	@Autowired
	private QnaDao qnaDao;

	@Override
	public List<Qna> loadQnaList(Page page) {
		return qnaDao.loadQnaList(page);
	}

	@Override
	public int totalQnaContentCount() {
		return qnaDao.totalQnaContentCount();
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
	public void reply(Qna qna){
		int ref = qna.getRef();
		int restep = qna.getRestep();
		int relevel = qna.getRelevel();
		qnaDao.updateRestep(ref, restep);
		//update 처리 후
				//원본 글의 것보다 restep과 relevel이 1씩 커야 하므로
				//입력 전에 restep값 과 relevel의 값을 1씩 증가하여 insert시킨다.
		qna.setRestep(restep+1);
		qna.setRelevel(relevel+1);
		qnaDao.insertRefContent(qna);//답변글 입력
	}
}
