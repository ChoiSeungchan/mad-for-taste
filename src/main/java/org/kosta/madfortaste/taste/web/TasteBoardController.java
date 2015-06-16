package org.kosta.madfortaste.taste.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.kosta.madfortaste.taste.domain.Article;
import org.kosta.madfortaste.taste.domain.TasteBoardImg;
import org.kosta.madfortaste.taste.service.TasteBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TasteBoardController {

	@Autowired
	private TasteBoardService tasteBoardService;
	
	@RequestMapping(value="registerArticleForm")
	public String registerArticleForm(Article article) {
		return "taste/registerArticleForm";
	}
	
	@RequestMapping(value="registerArticle")
	public String registerArticle(Article article) {
		System.out.println(article);
		System.out.println(article.getContents());
		return "redirect:/registerArticleForm";
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
	         System.out.println("finename=" +filename); //1
	         //파일 확장자
	         String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
	         System.out.println("filename_ext="+filename_ext); //2
	         //확장자를소문자로 변경
	         filename_ext = filename_ext.toLowerCase();
	         System.out.println("filename_ext="+filename_ext); //3
	         //파일 기본경로 _ 상세경로
	         File file = new File(new HttpServletRequestWrapper(request).getRealPath("/")+path);
	         System.out.println("path =" + path);//4
	         if(!file.exists()) {
	            file.mkdirs();
	         }
	         String realFileNm = null;
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	         String today= formatter.format(new java.util.Date());
	         realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
	         System.out.println("realFileNm="+realFileNm);//5
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
	         sFileInfo += "&sFileURL="+path+realFileNm;
	         PrintWriter print = response.getWriter();
	         print.print(sFileInfo);
	         print.flush();
	         print.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
