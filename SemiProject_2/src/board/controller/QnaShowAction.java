package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.*;
import board.model.InterBoardDAO;
import common.controller.AbstractController;
import member.model.*;

public class QnaShowAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		 super.getBasketCnt(request);
		
		 String userid = "";
		   
	   try {
		   HttpSession session = request.getSession();
		   MemberVO_PJW loginuser = (MemberVO_PJW) session.getAttribute("loginuser");
		   userid = loginuser.getUserid();
	   }catch(NullPointerException e) {
		   userid = "no";
	   }
		
		
		   String method = request.getMethod();
		
			if("GET".equalsIgnoreCase(method)) {
				
				String board_num = request.getParameter("board_num");
				
				// 해당글의 내용을 select 해와야 하는데 조건절은 where = ?
				// 위치홀더에 board_num 넣기
				
				InterBoardDAO bdao = new BoardDAO();
				BoardVO bvo = bdao.boardOneDetail(board_num);
				bdao.boardCnt(board_num);
				
				request.setAttribute("bvo", bvo);
				request.setAttribute("board_num", board_num);
				request.setAttribute("userid", userid);
			// *** 현재 페이지를 돌아갈 페이지(goBackURL)로 주소 지정하기 *** // 
				String goBackURL = request.getParameter("goBackURL");
			//	System.out.println("~~~ 확인용 goBackURL => " + goBackURL);
			//  ~~~ 확인용 goBackURL => /member/memberList.up?currentShowPageNo=5 sizePerPage=5 searchType=name searchWord=유	
				
				request.setAttribute("goBackURL", goBackURL);
				
			//	super.setRedirect(false);
				super.setViewPage("/WEB-INF/board/qnaShow.jsp");

			
			} else {
			// 로그인을 안한 경우 또는 일반사용자로 로그인 한 경우 
			String message = "관리자만 접근이 가능합니다.";
			String loc = "javascript:history.back()";
			
			request.setAttribute("message", message);
			request.setAttribute("loc", loc);
			
		//	super.setRedirect(false);
			super.setViewPage("/WEB-INF/msg.jsp");	
		}
		
	}

}
