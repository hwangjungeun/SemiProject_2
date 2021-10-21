package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVO;
import board.model.InterNoticeDAO;
import board.model.InterReviewDAO;
import board.model.NoticeDAO;
import board.model.NoticeVO;
import board.model.ReviewDAO;
import board.model.ReviewVO;
import common.controller.AbstractController;

public class ReviewDeleteEndAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		super.getBasketCnt(request);
		
		String method = request.getMethod();
        
        if("post".equalsIgnoreCase(method)) { // 수정할 글내용과 제목등을 적고 수정하기버튼을 눌러야 POST로 들어올 수 있다.
           
        	String rnum = request.getParameter("rnum");

	        
            InterReviewDAO rdao = new ReviewDAO();
          	int n = rdao.deleteReview(rnum);
          	
          	request.setAttribute("rnum", rnum);
          	
          	String message = "";
	        String loc = "";
           

	            if(n==1) {// 삭제 성공
	            	
	            	List<ReviewVO> reviewList = rdao.deleteReviewEnd();
	            	
	            	message = "삭제 성공!!";
	            	request.setAttribute("reviewList", reviewList);
	            	
	            	super.setViewPage("/WEB-INF/board/reviewDeleteEnd.jsp");
	            }
	            else {// 삭제 실패
	               message = "삭제 실패!!";
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
