package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractController;
import member.model.MemberVO_KMK;
import member.model.MemberVO_PJW;

public class ReviewDeleteAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		 super.getBasketCnt(request);
		 
		 String userid = "admin";
		 String method = request.getMethod();
		
		  // 관리자 로그인 시에만 글 삭제가 가능 하도록 한다 //
	      HttpSession session = request.getSession();
	      
	      MemberVO_PJW loginuser = (MemberVO_PJW) session.getAttribute("loginuser");

	      // 관리자로 로그인 되었을 때
	      if( loginuser != null && "admin".equals(loginuser.getUserid())) {

	    	 String rnum = request.getParameter("rnum");
	    //	 System.out.println("$$$$$$$$$rnum"+rnum);
	
	         request.setAttribute("rnum",rnum); 
	         

	         super.setViewPage("/WEB-INF/board/reviewDelete.jsp");
      
	      }
	      
	      else {
	         
	         String message = "잘못된 접근입니다.";
	         String loc = "javascript:history.back()";
	         
	         request.setAttribute("message", message);
	         request.setAttribute("loc", loc);
	         
	         super.setViewPage("/WEB-INF/msg.jsp");
	         
	      }

	}

}
