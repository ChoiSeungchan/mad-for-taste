package org.kosta.madfortaste.help.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Qna;


public interface QnaDao {
	public int totalQnaContentCount();
	public int totalQnaInputContentCount(String input);
	public List<Qna> loadQnaList(Page page);
	public List<Qna> loadQnaListByUser(HashMap<String, Object> map,String searchSelect);
	public List<Qna> loadQnaListByBoth(HashMap<String, Object> map,String searchSelect);
	public Qna getQnaContents(String pageNo);
	public int insertQna(Qna qna);//잘되면 1 안되면 0
	public void updateQna(Qna qna);
	public void deleteQna(String pageNo);
	public void updateViewCountQna(String articleNo);
	public void updateRestep(int ref, int restep);
	public void insertRefContent(Qna qna);
}
