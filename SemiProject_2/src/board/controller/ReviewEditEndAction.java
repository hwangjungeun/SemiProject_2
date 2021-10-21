package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.*;
import common.controller.AbstractController;

public class ReviewEditEndAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 String method = request.getMethod();
         
         if("post".equalsIgnoreCase(method)) { // 수정할 글내용과 제목등을 적고 수정하기버튼을 눌러야 POST로 들어올 수 있다.
            
        	String rnum = request.getParameter("rnum");
        	String rwriter = request.getParameter("rwriter");
	        String rtitle = request.getParameter("rtitle");
	        String rcontent = request.getParameter("rcontent");       
	        
	        InterReviewDAO rdao = new ReviewDAO();
           	int n = rdao.updateReview(rwriter, rtitle, rcontent, rnum);
           	
           	request.setAttribute("rnum", rnum);
           	request.setAttribute("rwriter", rwriter);
           	request.setAttribute("rtitle", rtitle);
           	request.setAttribute("rcontent", rcontent);
           	
           	String message = "";
	        String loc = "";
            

	            if(n==1) {// update 성공
	            	
	            	ReviewVO rvo = rdao.updateReviewEnd(rwriter, rtitle, rcontent, rnum);
	            	
	            	message = "글 수정 성공!!";
	            	request.setAttribute("rvo", rvo);
	            	
	            	super.setViewPage("/WEB-INF/board/reviewEditEnd.jsp");
	                
	            }
	            else {// update 실패
	               message = "글 수정 실패!!";
	               loc = "javascript:history.back()";
	               
	               request.setAttribute("message", message);
			       request.setAttribute("loc", loc);
			        
			       super.setViewPage("/WEB-INF/msg.jsp");
	            }
            
	            
	         }
         
 			else {
 				
 			// **** POST 방식으로 넘어온 것이 아니라면 **** //
 			
 			String message = "비정상적인 경로를 통해 들어왔습니다.!!";
 	        String loc = "javascript:history.back()";
 	         
 	        request.setAttribute("message", message);
 	        request.setAttribute("loc", loc);
 	         
 	        super.setViewPage("/WEB-INF/msg.jsp");
 	         
            
         }
         
         
   }

}
