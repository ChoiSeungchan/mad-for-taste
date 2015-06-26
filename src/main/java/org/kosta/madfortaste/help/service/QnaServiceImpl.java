package org.kosta.madfortaste.help.service;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.dao.QnaDao;
import org.kosta.madfortaste.help.domain.Qna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		// TODO Auto-generated method stub
		return 0;
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

}
