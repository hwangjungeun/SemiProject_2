package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.*;
import common.controller.AbstractController;
import member.model.*;

public class ReviewShowAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			   String method = request.getMethod();
			
				
					String rnum = request.getParameter("rnum");
					
					// 해당글의 내용을 select 해와야 하는데 조건절은 where = ?
					// 위치홀더에 board_num 넣기
					
					InterReviewDAO rdao = new ReviewDAO();
					ReviewVO rvo = rdao.reviewOneDetail(rnum);
					
					request.setAttribute("rvo", rvo);
					request.setAttribute("rnum", rnum);
				// *** 현재 페이지를 돌아갈 페이지(goBackURL)로 주소 지정하기 *** // 
					String goBackURL = request.getParameter("goBackURL");
				//	System.out.println("~~~ 확인용 goBackURL => " + goBackURL);
				//  ~~~ 확인용 goBackURL => /member/memberList.up?currentShowPageNo=5 sizePerPage=5 searchType=name searchWord=유	
					
					request.setAttribute("goBackURL", goBackURL);
					
				//	super.setRedirect(false);
					super.setViewPage("/WEB-INF/board/reviewShow.jsp");


			
			
		}

}
