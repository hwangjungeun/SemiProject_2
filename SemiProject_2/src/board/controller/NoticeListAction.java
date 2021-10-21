package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.*;
import common.controller.AbstractController;



public class NoticeListAction extends AbstractController {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	   
	   InterNoticeDAO ndao = new NoticeDAO();
	String checknull ="";
		   
	   HttpSession session = request.getSession();
	   
	     MultipartRequest mtrequest = null;
         
         ServletContext svlCtx = session.getServletContext();
         String uploadFileDir = svlCtx.getRealPath("/images");
         
         try {
		          mtrequest = new MultipartRequest(request,    // 리퀘스트 객체
		          uploadFileDir, // 파일이 업로드될 경로명
		          100*1080*1080,    // 10MB로 제한한다. (단위는 bite로 써야함)
		          "UTF-8",       // 인코딩 타입
		          new DefaultFileRenamePolicy());
		          checknull = mtrequest.getParameter("checknull");
         } catch(IOException e) {
         
        	 
      	   List<NoticeVO> noticeList =  ndao.selectPagingnotice();
      	   request.setAttribute("noticeList", noticeList);
      	   super.setViewPage("/WEB-INF/board/noticeList.jsp"); 
         
         } catch(NullPointerException e) {
        	 
         }
		     
		     
		     if("checknull".equals(checknull)) {
		    	 String notice_id = mtrequest.getParameter("notice_id");
				 String notice_subject = mtrequest.getParameter("notice_subject");
				 String notice_content = mtrequest.getParameter("notice_content");
				 String nimage = mtrequest.getFilesystemName("nimage");
			
				ndao.register(notice_id,notice_subject,notice_content,nimage);
				
				List<NoticeVO> noticeList =  ndao.selectPagingnotice();
				
				/////////////////////////////////////////////////////
				
				request.setAttribute("noticeList", noticeList);
				super.setViewPage("/WEB-INF/board/noticeList.jsp");	
		     }
			 
			
	  
	   
   }//end of public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

 }
