package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.*;
import common.controller.AbstractController;
import member.model.InterMemberDAO_KMK;
import member.model.MemberDAO_KMK;
import member.model.MemberVO_KMK;

public class ReviewListAction extends AbstractController {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	   

	     InterReviewDAO rdao = new ReviewDAO();
		
		 String rwriter = request.getParameter("rwriter");
		 String rtitle = request.getParameter("rtitle");
		 String rcontent = request.getParameter("rcontent");
		 
		 if(rwriter != null && rtitle != null && rcontent != null) {
			rdao.register(rwriter,rtitle,rcontent);
		 }
		 
		 String keyword = request.getParameter("keyword");
		 String type = request.getParameter("type");
		
		 
		 List<ReviewVO> reviewList =  rdao.selectPagingreview(keyword, type);
		 
		 
		
		/////////////////////////////////////////////////////
		
		request.setAttribute("reviewList", reviewList);
		
   //	super.setRedirect(false);
		super.setViewPage("/WEB-INF/board/reviewList.jsp");	
		
		return;	
	   
   }

 }
