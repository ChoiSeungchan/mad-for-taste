package org.kosta.madfortaste.help.service;

import java.util.List;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Qna;


public interface QnaService {
	public List<Qna> loadQnaList(Page page);
	public List<Qna> loadQnaListByInput(Page page,String searchSelect, String input);
	public int totalQnaContentCount(String input);
	public Qna getQnaContents(String no);
	public int insertQna(Qna qna);
	public void updateQna(Qna qna);
	public void deleteQna(String no);
	public Qna noCountGetContentsQna(String no);
	public void reply(Qna qna);
}
