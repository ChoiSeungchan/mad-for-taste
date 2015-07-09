package org.kosta.madfortaste.help.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.help.domain.Qna;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestQnaService {
	
	@Autowired
	private QnaService qnaService;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	
	/**
	 * 최초 페이지 로딩시 페이지 정보를 가져오고 게시글 리스트와 상세게시글 정보까지 모두
	 * 가져오는 Service이다. 본 Service는 검색을 할 시에도 사용가능 하도록 분기처리 되어있다.
	 */
	@Transactional
	@Test
	public void testLoadQnaService(){
		//currentPageNo와 같은 변수이다. 처음 로딩시에는
        //default로 1페이지를 보여주도록 처리한다.
		String pageNo=null; 
		//검색이용시 사용되는 검색 옵션이다. 처음 페이지 로딩시에는 null값이
		//들어오기 때문에 ""처리 해준다.
		String searchSelect="";
		//검색이용시 사용자가 타이핑하는 검색어이다. 처음페이지 로딩시에는 nul값이
		//들어오기때문에 ""처리해주고 검색 이용시 해당 검색어가 포함된것을 찾는다.
		String input="";
		//검색어 없을시
		//ListVO를 사용하지 않고 로직을 짜기 위해 map을 활용하였다.
		HashMap<String,Object> NoSearchMap = qnaService.loadQnaService(pageNo, searchSelect, input);
		assertNotNull(NoSearchMap.get("page"));//페이지정보 확인
		assertNotNull(NoSearchMap.get("qnaList"));//게시글 리스트 확인
		//검색어 존재시
		searchSelect="0";//0번 옵션은 사용자 검색옵션이다.
		input="Admin";//사용자계정 Admin이 작성하여 게시된 글을 찾는다.
		HashMap<String,Object> searchMap = qnaService.loadQnaService(pageNo, searchSelect, input);
		assertNotNull(searchMap.get("page"));//페이지정보 확인
		assertNotNull(searchMap.get("qnaList"));//게시글 리스트 확인
		log.info("검색결과 : " + searchMap.get("qnaList").toString());
		List<Qna> list = (List<Qna>) searchMap.get("qnaList");
		String sameAdmin = null;
		for (Qna qna : list) {
			if(input.equals(qna.getWriter())){
				sameAdmin = qna.getWriter();
			}
		}
		assertThat(sameAdmin,is("Admin"));
		
	}
	
	
	/**
	 * Q&A 메인페이지에서 게시글 상세보기를 위한 Service이다. 
	 * 본 서비스를 사용시에는 상세정보를 보여주고 조회수를 올려준다.
	 */
	@Transactional
	@Test
	public void testGetQnaContents(){
		String no = "1";//게시글 번호 예제로 1번 게시글을 조회해본다.
	    Qna countQna = qnaService.getQnaContents(no); //일반적인 조회시 실행되는 서비스
	    assertNotNull(countQna);//1번게시글이 존재하기 때문에 null이 나와선 안된다.
	    log.info("countQna result viewCount : " +countQna.getViewCount());
	    assertThat(countQna.getViewCount(), greaterThan(0));//한번 조회를 했기때문에 0보다는 커야한다.
	    Qna againCountQna = qnaService.getQnaContents(no);//다시한번더 상세를 했을경우
	    assertNotNull(againCountQna);//이 역시 null이 나와선 안된다.
	    log.info("againCountQna result viewCount : " +againCountQna.getViewCount());//againCountQna의 조회수
	    assertThat(againCountQna.getViewCount(), greaterThan(countQna.getViewCount())); //같으 조건에서 countQna의 조회수가 더 작아야 정상
	}
	
	/**
	 * 게시글 수정후 결과를 보여주었을때 ViewCount(조회수)가 올라가면 안되기 때문에
	 * 사용되는 서비스이다
	 */
	@Transactional
	@Test
	public void testNoCountGetContentsQna(){
		String no = "1";//게시글 번호 예제로 1번 게시글을 조회해본다.
	    Qna countQna = qnaService.getQnaContents(no); //일반적인 조회시 실행되는 서비스
	    assertNotNull(countQna);//1번게시글이 존재하기 때문에 null이 나와선 안된다.
	    log.info("countQna result viewCount : " +countQna.getViewCount());
	    assertThat(countQna.getViewCount(), greaterThan(0));//한번 조회를 했기때문에 0보다는 커야한다.
	    Qna noCountQna = qnaService.noCountGetContentsQna(no);//조회수를 올리지 않는 service 실행
	    assertNotNull(noCountQna);//이 역시 null이 나와선 안된다.
	    log.info("noCountQna result viewCount : " +countQna.getViewCount());//noCount의 조회수
	    assertEquals(countQna.getViewCount(),noCountQna.getViewCount()); //noCount의 조회수는 이전 조회수와 비교하여 변함이 없어야 한다.		
	}
	
	/**
	 * Q&A 게시글 입력을 위한 서비스
	 */
	@Transactional
	@Test
	public void testInsertQna(){
		String articleNo="999";//게시물 고유 글번호 해당 번호는 존재하지 않는 게시글 고유번호이다.
		assertNull(qnaService.noCountGetContentsQna(articleNo));//입력하지 않았기 때문에 null이어야 함
		Qna qna = new Qna("999", "java", "testInsert", "testInsert", 0, null,0,0,0);
		log.info("articleNo 확인 : " +qna.getArticleNo());
		assertThat(qna.getArticleNo(), is("999"));//삽입한 데이터의 articleNo가 999이어야 한다.
		int result = qnaService.insertQna(qna);
		assertThat(result, is(1));//정상 입력이 되었을시 result는 1이 되어야 한다.
		log.info("testInsertQna : " +qna.toString());
	}
	
	/**
	 * Q&A게시글 수정을 위한 서비스로써 본 서비스는 답글 수정시에도 사용된다.
	 */
	@Transactional
	@Test
	public void testUpdateQna(){
	String no = "1";//게시글 번호 1번에 해당하여 test 진행
	Qna beforeUpdate = qnaService.getQnaContents(no);//업데이트 전의 글상세정보
	assertNotNull(beforeUpdate);//데이터가 있는지 여부를 확인
	assertThat(beforeUpdate.getArticleNo(), is("1"));// 설정한 게시글을 불러왔는지 확인
	log.info("업데이트전  title : "+beforeUpdate.getTitle());//본 title은 test가 나와야 한다.
	String beforeUpdateTitle = beforeUpdate.getTitle();//update 전 Title 확보
	//클라이언트는 제목과 내용부만 수정할 수 있다.
	qnaService.updateQna(new Qna("1", beforeUpdate.getWriter(), "updateTest", "updateContent", beforeUpdate.getViewCount(), beforeUpdate.getRegDate()));
	Qna afterUpdate = qnaService.getQnaContents(no);//update 후 다시 조회해 본다.
	assertNotNull(afterUpdate);//업데이트를 한것이기 때문에 존재해야한다.
	String afterUpdateTitle = afterUpdate.getArticleNo();//update후의 Title 확보
	assertNotEquals(beforeUpdateTitle, afterUpdateTitle);//수정된 후의 title이 일치해서는 안된다.
	
	
	}
	
	/**
	 * Q&A 게시글의 삭제시 사용되는 서비스
	 * 본 서비스는 답글을 삭제시에도 사용된다.
	 */
	@Transactional
	@Test
	public void testDeleteQna(){
		String no = "1";//1번 게시글을 대상으로 삭제 test를 실시
		Qna beforeQna = qnaService.getQnaContents(no);
		assertNotNull(beforeQna);//삭제대상 글이 존재하는 지여부를 확인
		log.info("삭제 대상 정보 : " +beforeQna.toString());//삭제대상 정보
		String beforeQnaArticleNo = beforeQna.getArticleNo();//삭제 대상 게시글 번호
		qnaService.deleteQna(beforeQnaArticleNo);//primary key인 게시글 번호를 조회하여 해당 게시글 삭제
		Qna afterQna = qnaService.getQnaContents(beforeQnaArticleNo);
		assertNull(afterQna);//삭제 여부 확인 ->null이 나와야 한다.
	}
	
	/**
	 * 답글 작성시 계층별 답글을 작성하기 위한 서비스 이다.
	 */
	@Transactional
	@Test
	public void testReply(){
		String articleNo="1000";//게시물 고유 글번호 해당 번호는 존재하지 않는 게시글 고유번호이다.
		assertNull(qnaService.noCountGetContentsQna(articleNo));//입력하지 않았기 때문에 null이어야 함
		Qna qna = new Qna("1000", "java", "testInsert", "testInsert", 0, null,0,0,0);
		log.info("articleNo 확인 : " +qna.getArticleNo());
		assertThat(qna.getArticleNo(), is("1000"));//삽입한 데이터의 articleNo가 1000이어야 한다.
		int result = qnaService.insertQna(qna);
		assertThat(result, is(1));//정상 입력이 되었을시 result는 1이 되어야 한다.
		log.info("testInsertQna : " +qna.toString());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
