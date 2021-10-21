package board.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface InterReviewDAO {

	// 리뷰 작성시키는 메소드
	void register(String rwriter, String rtitle, String rcontent) throws SQLException;

	// 리뷰 후기글 목록 보여주고 글 찾기
	List<ReviewVO> selectPagingreview(String keyword, String type) throws SQLException;

	// 리뷰 수정하기
	int updateReview(String rwriter, String rtitle, String rcontent, String rnum) throws SQLException;
		
	// 수정한 리뷰글 보여주기
	ReviewVO updateReviewEnd(String rwriter, String rtitle, String rcontent, String rnum) throws SQLException;

	// rnum 값을 입력받아서 하나의 게시글에 대한 상세정보를 알아오기(select) 
	ReviewVO reviewOneDetail(String rnum) throws SQLException;

	// 리뷰글 삭제하기
	int deleteReview(String rnum) throws SQLException;

	// 리뷰글 삭제 후 목록에서 삭제 확인
	List<ReviewVO> deleteReviewEnd() throws SQLException;


	

	
	

	
	




	

}
