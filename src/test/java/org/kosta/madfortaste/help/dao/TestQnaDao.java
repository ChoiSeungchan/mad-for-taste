package org.kosta.madfortaste.help.dao;


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
/**
 * DAO를 활용한 개발전 TDD방식으로 테스트를 하는 클래스
 * @author Choi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/root-context.xml")
public class TestQnaDao {
	@Autowired
	private QnaDao qnaDAO;
	
	private Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * Q&A 페이지에서 해당 글을 클릭하면 상세정보를 가져오는 메서드
	 */
	@Test
	public void testGetQnaContents(){
		String articleNo = "1";
		int totalCount = qnaDAO.totalQnaContentCount();//글을 총 갯수를 가져오는것
		assertThat(totalCount, greaterThan(0));//반드시 0보다 큰 1개 이상이 들어있어야 한다.
		Qna qna = qnaDAO.getQnaContents(articleNo);//임의의 글 Number를 삽입하여 데이터를 불러온다.
		assertNotNull(qna);//불러왔을때 null이 나와서는 안된다. 
		log.info("testGetQnaContents : " +qna.toString());
	}
	
	/**
	 * Q&A 페이지에 글을 작성할 수 있는 메서드
	 */
	@Transactional
	@Test
	public void testInsertQna() {
		Qna qna = new Qna("1", "java", "testInsert", "testInsert", 0, null,0,0,0);
		log.info("articleNo 확인 : " +qna.getArticleNo());
		assertThat(qna.getArticleNo(), is("1"));//삽입한 데이터의 articleNo가 1이어야 한다.
		int result = qnaDAO.insertQna(qna);
	    assertThat(result, is(1));//정상 입력이 되었을시 result는 1이 되어야 한다.
		log.info("testInsertQna : " +qna.toString());
	}
	
	/**
	 * Q&A작성후 제목,내용 을 수정할 수 있는 메서드
	 * 본 테스트에서는 제목을 케이스로 TestCode 작성
	 */
	@Transactional
	@Test
	public void testUpdateQna(){
		int totalCount = qnaDAO.totalQnaContentCount();
		assertThat(totalCount, greaterThan(0));//데이터가 실제 들어있는지를 확인
		Page page = new Page(totalCount);
		List<Qna> qnaList = qnaDAO.loadQnaList(page);
		Qna beforeQna = qnaList.get(0);//데이터가 들어있음을 확인하였기 때문에 0번째 인덱스를 활용하여 업데이트 확인
		log.info("업데이트 전 : "+ beforeQna.getTitle());
		String berforeQnaArticleNo = beforeQna.getArticleNo();
		String beforeQnaTitle = beforeQna.getTitle();
		beforeQna.setTitle("testingUpdate");
		qnaDAO.updateQna(beforeQna);
		Qna afterQna = qnaDAO.getQnaContents(berforeQnaArticleNo);
		assertNotEquals(beforeQnaTitle, afterQna.getTitle());//업데이트 전,후의 title이 반드시 달라야 정상 작동된것
		log.info("업데이트 후 : " + afterQna.getTitle());
	}
	
	/**
	 * Q&A 에서 이미 작성되어 있는 글을 대상으로 삭제가 가능한 메서드
	 */
	@Transactional
	@Test
	public void testDeleteQna(){
		int totalCount = qnaDAO.totalQnaContentCount();
		assertThat(totalCount,greaterThan(0));//qna 테이블에 data가 있는지를 확인
		Page page = new Page(totalCount);//page 정보를 불러오고
		List<Qna> qnaList = qnaDAO.loadQnaList(page);//qna 페이지의 list를 불러옴
		Qna beforeQna = qnaList.get(0);// 0번째 인덱스는 반드시 존재해야함
		beforeQna = qnaDAO.getQnaContents(beforeQna.getArticleNo());
		assertNotNull(beforeQna);//해당자료의 존재여부 확인
		log.info("해당자료 delete 전 : " + beforeQna.toString());
		qnaDAO.deleteQna(beforeQna.getArticleNo());
		Qna afterQna = qnaDAO.getQnaContents(beforeQna.getArticleNo());
		log.info("삭제 후 : "+afterQna);
		assertNull(afterQna);		
	}
	
	/**
	 * 페이징처리와 더불어 메인페이지에서 입력된 글들을 리스트로 보여주는 메서드
	 */
	@Transactional
	@Test
	public void testLoadQnaList(){
		String currentPageNo = null;//현재 페이지 넘버
		assertNull(currentPageNo);//처음에는 페이지번호를 누르지 않기 때문에 null이어야 한다.
		//처음 페이지가 null이기 때문에 NullPointException을 방지하기 위한 분기처리를 한다.
		//본 TestCode에서는 articleNo 1과 비교하기 위해 5페이지로 초기화 한다.
		if(currentPageNo==null||currentPageNo==""){
			currentPageNo="5";
		}
		assertThat(currentPageNo, is("5"));//분기처리를 하였기 때문에 1이 나와야 한다.
		qnaDAO.insertQna(new Qna("1", "java", "testInsert", "testInsert", 0, null,0,0,0));
	    Qna qna = qnaDAO.getQnaContents("1");
	    String beforeArticleNo;//페이지를 거쳐 리스트로 뿌려진 데이터와 비교할 변수
	    beforeArticleNo = qna.getArticleNo();
	    assertThat(beforeArticleNo, is("1"));//삽입한 데이터의 articleNo가 1이다. 
	    log.info("삽입되어있는 데이터 확인 : " +qna.toString());
		int totalCount = qnaDAO.totalQnaContentCount();
		assertThat(totalCount, greaterThan(0));//자료 존재 여부 확인
		Page page = new Page(totalCount);//PagingBean에 현재 게시물의 총 개수를 삽입
		page.setCurrentPage(Integer.parseInt(currentPageNo));//상위에서 분기처리된 페이지 넘버 조정
		List<Qna> list = qnaDAO.loadQnaList(page);
		String confirm = null;
		for (Qna qnalist : list) {
				if(qnalist.getArticleNo().equals("1")){
					confirm = qnalist.getArticleNo();
				}
		}
		log.info("통과한 articleNo : " +confirm);
		/* 제일 처음 삽입한 데이터의 변수중 qna.getArticleNo()와 
		 * 데이터가 삽입되고 페이징 처리를 지나서 최종 리스트단계에서
		 * 뽑아올린 confirm의 articleNo를 비교하여 페이징처리시 데이터가 잘 넘어가는지를
		 * 확인한다. 
		 */
		assertThat(confirm, is("1")); 
		
	}
	

}
