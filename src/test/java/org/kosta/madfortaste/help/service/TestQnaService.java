/*package org.kosta.madfortaste.help.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

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
	
	*//**
	 * Controller에서 paging 처리를 같이 처리하는데 있어
	 * Q&A의 총 게시글의 개수를 가져오는 Service이다.
	 * 또한 검색을 할 시에도 본 Service를 사용한다. 
	 *//*
	@Transactional
	@Test
	public void testTotaQnaContentCount(){
		String input;//검색어
		Page page = null;
		int result;
		// 검색어가 없을시
			input = "";
			result = qnaService.totalQnaContentCount(input);
			log.info("검색어가 없을시 총 게시글의 개수 : " +result);
			assertNotNull(result);//result가 나와야 정상
			page = new Page(result);
			log.info("검색어가 없을시 전체 페이지정보 : " +page.toString());
			assertNotNull(page.toString());//페이징 처리까지 정상적으로 되야 한다.
		//검색어가 존재할시
			input = "java";
			result = qnaService.totalQnaContentCount(input);
			log.info("검색어가 존재할시 총 게시글의 개수 : " +result);
			assertNotNull(result);//result가 나와야 정상
			page = new Page(result);
			log.info("검색어가 존재할시에 총 페이지정보 : " +page.toString());
			assertNotNull(page.toString());//페이징 처리까지 정상적으로 되야 한다.
	}
	
	*//**
	 * Q&A 메인페이지에서 게시글 상세보기를 위한 Service이다. 
	 *//*
	@Transactional
	@Test
	public void testGetQnaContents(){
		String no = "1"; //해당 articleNo의 게시글을 상세보기한다.
		String input = "";//검색어 옵션 일반적인 글상세조회 test이므로 검색옵션은 없는걸로 처리한다.
		int totalCount = qnaService.totalQnaContentCount(input);//검색어가 없을시에는 전체를 대상으로 진행한다. 
		assertThat(totalCount, greaterThan(0));//전체 자료 존재여부 확인
		Qna qna = new Qna("1", "java", "testInsert", "testInsert", 0, null,0,0,0);
		int beforeViewCount = qna.getViewCount();//게시글 조회전 조회수
		 qna = qnaService.getQnaContents(no);//게시글 상세보기 실행
		int afterviewCount = qna.getViewCount();//게시글 조회전 조회수
		assertThat(afterviewCount, greaterThan(beforeViewCount));//게시글을 상세보기하면 
		assertNotNull(qna);//null이 아닐시 정상
		log.info("articleNo 1번에 해당하는 게시글 상세내역 : " +qna.toString());	
		String confirmAriticleNo = qna.getArticleNo();
		assertThat(no, is(confirmAriticleNo));//지정한 articleNo 1번과 불러온 글의 aritcleNo를 비교
	}
	*//**
	 * 게시글 수정시에는 ViewCount(조회수)가 올라가면 안되기 때문에
	 * 수정후에 수정된 결과를 보여주는데 사용되는 서비스이다
	 *//*
	@Transactional
	@Test
	public void testNoCountGetContentsQna(){
		String no = "1"; //해당 articleNo의 게시글을 상세보기한다.
		String input = "";//검색어 옵션 일반적인 상세글조회 test이므로 검색옵션은 없는걸로 처리한다.
		int totalCount = qnaService.totalQnaContentCount(input);//검색어가 없을시에는 전체를 대상으로 진행한다. 
		assertThat(totalCount, greaterThan(0));//전체 자료 존재여부 확인
		Qna qna = new Qna("1", "java", "testInsert", "testInsert", 0, null,0,0,0);
//		int beforeViewCount = qna.getViewCount();//게시글 조회전 조회수
		 qna = qnaService.noCountGetContentsQna(no);//게시글 상세보기 실행
		int afterviewCount = qna.getViewCount();//게시글 조회전 조회수
		assertEquals(0, afterviewCount,0);//본 서비스를 사용하면 조회수에 변화가 없다는 것을 확인
		assertNotNull(qna);//null이 아닐시 정상
		log.info("articleNo 1번에 해당하는 게시글 상세내역 : " +qna.toString());	
		String confirmAriticleNo = qna.getArticleNo();
		assertThat(no, is(confirmAriticleNo));//지정한 articleNo 1번과 불러온 글의 aritcleNo를 비교
	}
	
	*//**
	 * Q&A 게시글 입력을 위한 서비스
	 *//*
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
	
	*//**
	 * Q&A게시글 수정을 위한 서비스 본 서비스는 답글 수정시에도 사용한다. 
	 *//*
	@Transactional
	@Test
	public void testUpdateQna(){
		String input = "";//검색어 옵션 일반적인 업데이트 test이므로 검색옵션은 없는걸로 처리한다.
		int totalCount = qnaService.totalQnaContentCount(input);//검색어가 없을시에는 전체를 대상으로 진행한다.
		assertThat(totalCount, greaterThan(0));//전체 자료 존재여부 확인
		Page page = new Page(totalCount);
		List<Qna> qnaList = qnaService.loadQnaList(page);
		Qna beforeQna = qnaList.get(0);//데이터가 들어있음을 확인하였기 때문에 0번째 인덱스를 활용하여 업데이트 확인
		log.info("업데이트 전 : "+ beforeQna.getTitle());
		String berforeQnaArticleNo = beforeQna.getArticleNo();
		String beforeQnaTitle = beforeQna.getTitle();
		beforeQna.setTitle("testingUpdateService");
		qnaService.updateQna(beforeQna);
		Qna afterQna = qnaService.getQnaContents(berforeQnaArticleNo);
		assertNotEquals(beforeQnaTitle, afterQna.getTitle());//업데이트 전,후의 title이 반드시 달라야 정상 작동된것
		log.info("업데이트 후 : " + afterQna.getTitle());
	}
	
	*//**
	 * Q&A 게시글의 삭제시 사용되는 서비스
	 * 본 서비스는 답글을 삭제시에도 사용된다.
	 *//*
	@Transactional
	@Test
	public void testDeleteQna(){
		String input = "";//검색어 옵션 일반적인 글삭제 test이므로 검색옵션은 없는걸로 처리한다.
		int totalCount = qnaService.totalQnaContentCount(input);//검색어가 없을시에는 전체를 대상으로 진행한다.
		assertThat(totalCount,greaterThan(0));//qna 테이블에 data가 있는지를 확인
		Page page = new Page(totalCount);//page 정보를 불러오고
		List<Qna> qnaList = qnaService.loadQnaList(page);//qna 페이지의 list를 불러옴
		Qna beforeQna = qnaList.get(0);// 0번째 인덱스는 반드시 존재해야함
		beforeQna = qnaService.getQnaContents(beforeQna.getArticleNo());
		assertNotNull(beforeQna);//해당자료의 존재여부 확인
		log.info("해당자료 delete 전 : " + beforeQna.toString());
		qnaService.deleteQna(beforeQna.getArticleNo());
		Qna afterQna = qnaService.getQnaContents(beforeQna.getArticleNo());
		log.info("삭제 후 : "+afterQna);
		assertNull(afterQna);		
	}
	
	*//**
	 * 답글 작성시 계층별 답글을 작성하기 위한 서비스 이다.
	 *//*
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
*/