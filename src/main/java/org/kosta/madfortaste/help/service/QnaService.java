package org.kosta.madfortaste.help.service;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Qna;


public interface QnaService {
	public List<Qna> loadQnaList(Page page);
	public int totalQnaContentCount();
	public Qna getQnaContents(String no);
	public int insertQna(Qna qna);
	public void updateQna(Qna qna);
	public void deleteQna(String no);
	public Qna noCountGetContentsQna(String no);
}
