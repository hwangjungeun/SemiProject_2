package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.*;
import common.controller.AbstractController;


public class QnaListAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			InterBoardDAO bdao = new BoardDAO();
			
			String board_id = request.getParameter("board_id");
			String board_subject = request.getParameter("board_subject");
			String board_content = request.getParameter("board_content");
			if(board_id != null && board_subject != null && board_content != null) {
				bdao.register(board_id,board_subject,board_content);
			
			}
			
			String keyword = request.getParameter("keyword");
			 String type = request.getParameter("type");
			
			
			List<BoardVO> boardList =  bdao.selectPagingboard(keyword, type);
			
			
			/////////////////////////////////////////////////////
			
			request.setAttribute("boardList", boardList);
			
	        //	super.setRedirect(false);
			super.setViewPage("/WEB-INF/board/qnaList.jsp");	
			
			return;

		}
		
	}

