package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractController;
import member.model.*;

public class ReviewWriteAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		  super.getBasketCnt(request);
    	  super.setViewPage("/WEB-INF/board/reviewWrite.jsp");			
	      
	}

		  
}
