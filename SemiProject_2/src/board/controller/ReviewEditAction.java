package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractController;
import member.model.MemberVO_KMK;

public class ReviewEditAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		  super.getBasketCnt(request);
		
		  String method = request.getMethod();
		
		  
	      // 관리자로 로그인 되었을 때
	      //if( loginuser != null && "admin".equals(loginuser.getUserid())) {

	    	 String rnum = request.getParameter("rnum");
	         String rwriter = request.getParameter("rwriter");
	         String rtitle = request.getParameter("rtitle");
	         String rcontent = request.getParameter("rcontent");
	
	         request.setAttribute("rnum",rnum); 
	         request.setAttribute("rwriter",rwriter); 
	         request.setAttribute("rtitle",rtitle); 
	         request.setAttribute("rcontent",rcontent); 
	         
	         // 글 수정을 위하여 새로운정보를 입력하도록 View 페이지로 이동한다.
	         super.setViewPage("/WEB-INF/board/reviewEdit.jsp");
         
	      //}
	      
			/*
			 * else {
			 * 
			 * String message = "잘못된 접근입니다."; String loc = "javascript:history.back()";
			 * 
			 * request.setAttribute("message", message); request.setAttribute("loc", loc);
			 * 
			 * super.setViewPage("/WEB-INF/msg.jsp");
			 * 
			 * }
			 */
      
   }

}
