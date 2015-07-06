package org.kosta.madfortaste.taste.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.madfortaste.common.config.ExpConfig;
import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.taste.domain.Article;
import org.kosta.madfortaste.taste.domain.Reply;
import org.kosta.madfortaste.taste.domain.TasteBoardImg;
import org.kosta.madfortaste.taste.service.ReplyService;
import org.kosta.madfortaste.taste.service.RestaurantService;
import org.kosta.madfortaste.taste.service.TasteBoardService;
import org.kosta.madfortaste.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TasteBoardController {

	@Autowired
	private TasteBoardService tasteBoardService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="getArticles/{currentPage}")
	public String getArticles(@PathVariable int currentPage, Model model) {
		Page page = new Page(tasteBoardService.getTotalCount());
		page.setCurrentPage(currentPage);
		Page topRankPage = new Page(tasteBoardService.getTotalCount());
		topRankPage.setPageSize(3);
		model.addAttribute("topRankArticle", tasteBoardService.getArticlesOredrByRank(topRankPage));
		model.addAttribute("tasteBoard", tasteBoardService.getArticles(page));
		model.addAttribute("page", page);
		return "home";
	}
	@RequestMapping(value="registerArticleForm")
	public String registerArticleForm(Article article,Model model) {
		model.addAttribute("listDo", restaurantService.selectSi());
		return "taste/registerArticleForm";
	}
	
	@RequestMapping(value="registerArticle")
	public String registerArticle(Article article,String doVal,String siVal,String dongVal,String name) {
		Map<String, String> map=new HashMap<String, String>();
		String si="";
		String gu="  ";
		String dong="  ";
		si=doVal;
		gu+=siVal;
		dong+=dongVal;
		map.put("si", si);
		map.put("gu", gu);
		map.put("dong", dong);
		map.put("name", name);
		article = tasteBoardService.insertArticle(article,map);
		return "redirect:article/"+article.getArticleNo();
	}
	
	@RequestMapping(value="article/{articleNo}")
	public String getArticle(
			@PathVariable int articleNo, Model model,
			@CookieValue(value = "getArticleLog", required = false) Cookie cookie,
			HttpServletResponse res) {
		tasteBoardService.upHits(articleNo, cookie, res);
		Article article = tasteBoardService.getArticleByNo(articleNo);
		int good=article.getGood();
		int bad=article.getBad();
		
		List<Reply> replies = replyService.getReplies(articleNo);
		model.addAttribute("article", article);
		if(replies.size()!=0)model.addAttribute("replies", replies);
		return "taste/articleView";
	}
	
	@RequestMapping(value="updateArticleForm/{articleNo}")
	public String updateArticleForm(@PathVariable int articleNo, Model model) {
		Article article = tasteBoardService.getArticleByNo(articleNo);
		model.addAttribute("article", article);
		return "taste/updateArticleForm";
	}
	
	@RequestMapping(value="updateArticle")
	public String updateArticle(Article article) {
		System.out.println(article);
		tasteBoardService.updateArticle(article);
		return "redirect:article/"+article.getArticleNo();
	}
	
	@RequestMapping(value="deleteArticle/{articleNo}")
	public String deleteArticle(@PathVariable int articleNo) {
		tasteBoardService.deleteArticle(articleNo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="article/upGood")
	public List<String> upGood(int articleNo, String id, int resNo) {
		boolean flag = false;
		List<String> list = new ArrayList<String>();
		if(!id.trim().equals("")) {
			flag = tasteBoardService.upGood(articleNo, id, resNo);
			if(flag==false) {
				list.add("success");
				list.add(ExpConfig.GOOD_BAD+"");
			} else list.add("fail");
		} else {
			list.add("notLogon");
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="article/upBad")
	public List<String> upBad(int articleNo, String id, int resNo) {
		boolean flag = false;
		List<String> list = new ArrayList<String>();
		if(!id.trim().equals("")) {
			flag = tasteBoardService.upBad(articleNo, id, resNo);
			if(flag==false) {
				list.add("success");
				list.add(ExpConfig.GOOD_BAD+"");
			} else list.add("fail");
		} else {
			list.add("notLogon");
		}
		return list;
	}
	
	@Resource(name="tasteBoardImg")
	private String path;
	
	//단일파일업로드
	@RequestMapping("/photoUpload")
	public String photoUpload(HttpServletRequest request, TasteBoardImg img){
	    String callback = img.getCallback();
	    String callback_func = img.getCallback_func();
	    String file_result = "";
	    try {
	        if(img.getFiledata() != null && img.getFiledata().getOriginalFilename() != null && !img.getFiledata().getOriginalFilename().equals("")){
	            //파일이 존재하면
	            String original_name = img.getFiledata().getOriginalFilename();
	            String ext = original_name.substring(original_name.lastIndexOf(".")+1);
	            //파일 기본경로 _ 상세경로
	            File file = new File(path);
	            System.out.println("path:"+path);
	            //디렉토리 존재하지 않을경우 디렉토리 생성
	            if(!file.exists()) {
	                file.mkdirs();
	            }
	            //서버에 업로드 할 파일명(한글문제로 인해 원본파일은 올리지 않는것이 좋음)
	            String realname = UUID.randomUUID().toString() + "." + ext;
	        ///////////////// 서버에 파일쓰기 ///////////////// 
	            img.getFiledata().transferTo(new File(path+realname));
	            file_result += "&bNewLine=true&sFileName="+original_name+"&sFileURL="+path+realname;
	        } else {
	            file_result += "&errstr=error";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "redirect:" + callback + "?callback_func="+callback_func+file_result;
	}
	
	//다중파일업로드
	@RequestMapping(value="/multiplePhotoUpload", method=RequestMethod.POST)
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response){
	    try {
	         //파일정보
	         String sFileInfo = null;
	         //파일명을 받는다 - 일반 원본파일명
	         String filename = request.getHeader("file-name");
	         //파일 확장자
	         String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
	         //확장자를소문자로 변경
	         filename_ext = filename_ext.toLowerCase();
	         //파일 기본경로 _ 상세경로
	         File file = new File(new HttpServletRequestWrapper(request).getRealPath("/")+path);
	         if(!file.exists()) {
	            file.mkdirs();
	         }
	         String realFileNm = null;
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	         String today= formatter.format(new java.util.Date());
	         realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
	         String rlFileNm = new HttpServletRequestWrapper(request).getRealPath("/") + path + realFileNm;
	         ///////////////// 서버에 파일쓰기 ///////////////// 
	         InputStream is = request.getInputStream();
	         OutputStream os=new FileOutputStream(rlFileNm);
	         System.out.println("rlFileNm = " +rlFileNm);
	         int numRead;
	         byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
	         while((numRead = is.read(b,0,b.length)) != -1){
	            os.write(b,0,numRead);
	         }
	         if(is != null) {
	            is.close();
	         }
	         os.flush();
	         os.close();
	         ///////////////// 서버에 파일쓰기 /////////////////
	         // 정보 출력
	         sFileInfo += "&bNewLine=true";
	         // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
	         sFileInfo += "&sFileName="+ filename;
	         sFileInfo += "&sFileURL=/madfortaste/"+path+realFileNm;
	         PrintWriter print = response.getWriter();
	         print.print(sFileInfo);
	         print.flush();
	         print.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@RequestMapping("listDoClickAjax")//시.도 클릭했을때 하위 시.군.구를 출력
	@ResponseBody
	public List<String> listDoClick(String doVal){
		System.out.println(doVal);
		System.out.println(restaurantService.selectGu(doVal));
		return restaurantService.selectGu(doVal);
	}
	
	@RequestMapping(value="listSiClickAjax",method=RequestMethod.POST)
	//시.군.구 를 클릭시 하위 읍.면.동을 출력
	@ResponseBody
	public List<String> listSiClick(String doVal,String siVal){
		Map<String, String> map=new HashMap<String, String>();
		map.put("si", doVal);map.put("gu", siVal);
		return restaurantService.selectDong(map);
	}
	
	@RequestMapping("findRestaurantAjax")//레스토랑 존재여부 확인
	@ResponseBody
	public List<String> findRestaurant(String doVal,String siVal,String dongVal,String name){
		Map<String, String> map=new HashMap<String, String>();
		List<String> list=new ArrayList<String>();
		map.put("si", doVal);
		map.put("gu", siVal);
		map.put("dong", dongVal);
		map.put("name", name);		
		list.add(restaurantService.SelectRestaurantByAddress(map));
		return list;
	}
}
