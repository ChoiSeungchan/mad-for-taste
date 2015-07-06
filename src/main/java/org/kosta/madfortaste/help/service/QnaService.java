package org.kosta.madfortaste.help.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Qna;


public interface QnaService {
	public Qna getQnaContents(String no); 
	public HashMap<String,Object> loadQnaService(String pageNo,String searchSelect,String input);
	public int insertQna(Qna qna);
	public void updateQna(Qna qna);
	public void deleteQna(String no);
	public Qna noCountGetContentsQna(String no);
	public void reply(Qna qna);
}
