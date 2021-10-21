package board.model;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import util.security.AES256;
import util.security.SecretMyKey;

public class ReviewDAO implements InterReviewDAO {
	
	private DataSource ds;// DataSource ds 는 아파치톰캣이 제공하는 DBCP(DB Connection Pool) 이다.
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
	
 // 기본생성자
    public ReviewDAO() {
       try {
          Context initContext = new InitialContext();
           Context envContext  = (Context)initContext.lookup("java:/comp/env");
           ds = (DataSource)envContext.lookup("jdbc/semioracle"); //web.xml => ref에 값과 동일해야한다.
           
           // SecretMyKey.KEY 는 우리가 만든 비밀키이다.
       } catch (NamingException e) { //NamingException
          e.printStackTrace();
       }
       
    }
    
	// 사용한 자원을 반납하는 close() 메소드 생성하기 
    private void close() {
       try {
          if(rs != null)    {rs.close();    rs=null;}
          if(pstmt != null) {pstmt.close(); pstmt=null;}
          if(conn != null)  {conn.close();  conn=null;}
       } catch(SQLException e) {
          e.printStackTrace();
       }
       
    }
    
    
    // 리뷰내용 작성 메소드 //
	@Override
	public void register(String rwriter, String rtitle, String rcontent) throws SQLException {
		
		try {
  			conn = ds.getConnection();
  			
  			String sql = " insert into tbl_review(rnum, rwriter, rtitle, rcontent, rdate) "
  					   + " values(rnum.nextval, ?, ?, ?, default) ";
  			
  			pstmt = conn.prepareStatement(sql);
  			
  			pstmt.setString(1, rwriter);
  			pstmt.setString(2, rtitle);
  			pstmt.setString(3, rcontent);
  			
  	        pstmt.executeUpdate();
  	        
  		} catch (SQLException e) {
  			e.printStackTrace();
  		} finally {
  			close();
  		}
		
	}// end of public void register(String rwriter, String rtitle, String rcontent)------------------------------

	
	// 리뷰 후기글 목록 보여주기
		@Override
		public List<ReviewVO> selectPagingreview(String keyword, String type) throws SQLException {
			
			List<ReviewVO> reviewList = new ArrayList<>();
		      
		      try {
		         conn = ds.getConnection();

		         String sql = " select rnum, rwriter, rtitle, rcontent, rdate "
		        		 	+ " from tbl_review "; 
		         
		            if(keyword != null && keyword != "") {
		            	sql = sql + "where " + type + " like '%"+ keyword +"%'";
		            }
		            
		            pstmt = conn.prepareStatement(sql);

		            rs = pstmt.executeQuery();
		            
		            while(rs.next()) {
		             //  System.out.println("aaa");
		            	ReviewVO rvo = new ReviewVO();
		               
		               rvo.setRnum(rs.getInt(1));
		               rvo.setRwriter(rs.getString(2));
		               rvo.setRtitle(rs.getString(3));
		               rvo.setRcontent(rs.getString(4));
		               rvo.setRdate(rs.getDate(5));
		               
		               reviewList.add(rvo);
		               
		            }// end of while---------------------------
		            
		      } catch(SQLException e) {   
		         e.printStackTrace();
		      } finally {
		         close();
		      }
		      
		      return reviewList;
		}// end of public List<ReviewVO> selectPagingreview()----------------------
		
	
	// rnum 값을 입력받아서 하나의 게시글에 대한 상세정보를 알아오기(select) 
	@Override
	public ReviewVO reviewOneDetail(String rnum) throws SQLException {
		
		ReviewVO rvo = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = " select rnum, rwriter, rtitle, rcontent, rdate "
					   + " from tbl_review " 
                       + " where rnum = ? ";
			
			pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, rnum);
	                  
	        rs = pstmt.executeQuery();
	         
	        if(rs.next()) {  
	               
	            rvo = new ReviewVO();
	            
	            rvo.setRnum(rs.getInt(1));
	            rvo.setRwriter(rs.getString(2));
	            rvo.setRtitle(rs.getString(3));
	            rvo.setRcontent(rs.getString(4));
	            rvo.setRdate(rs.getDate(5));

	        }
			
		} catch(SQLException e) {   
	         e.printStackTrace();
	    } finally {
			close();
		}
		
		return rvo;
	} // end of public ReviewVO reviewOneDetail(String rnum)----------------------------------------

	
	  // 리뷰 수정하기
	  @Override
	  public int updateReview(String rwriter, String rtitle, String rcontent, String rnum) throws SQLException {
		  
		  int n = 0;
		  
		  try { 
			  conn = ds.getConnection();
		  
			  String sql = " update tbl_review "+
						   " set rwriter = ?, rtitle = ?, rcontent = ? "+
						   " where rnum = ? ";
			  
			  pstmt = conn.prepareStatement(sql);
			  
			  pstmt.setString(1, rwriter); 
			  pstmt.setString(2, rtitle);
			  pstmt.setString(3, rcontent);
			  pstmt.setString(4, rnum);
			  
			  n = pstmt.executeUpdate();
		  
		  } finally {
			  close(); 
		  }
		  
		  return n; 
	  }// end of public public int updateNotice(String rwriter, String rtitle, String rcontent, String rnum)---------------
	  
	  
	  // 수정한 글 보여주기
	  @Override
	  public ReviewVO updateReviewEnd(String rwriter, String rtitle, String rcontent, String rnum) throws SQLException {
	  
	  ReviewVO rvo = null;
	  
	  try {
		  conn = ds.getConnection();
	  
		  String sql = " select rnum, rwriter, rtitle, rcontent "
				  	 + " from tbl_review ";
		  
		  pstmt = conn.prepareStatement(sql);
		  
		  rs = pstmt.executeQuery();
		  
		  while(rs.next()) {
		  
		  rvo = new ReviewVO(); 
		  
		  rvo.setRnum(rs.getInt(1));
		  rvo.setRwriter(rs.getString(2)); 
		  rvo.setRtitle(rs.getString(3));
		  rvo.setRcontent(rs.getString(4));
		  
		  }// end of while---------------------------
	  
	  } catch(SQLException e) { 
		  e.printStackTrace(); 
		  
	  } finally { 
		  close(); 
	  }
	  
	  return rvo; 
	  }// end of public ReviewVO updateReviewEnd(String rwriter, String rtitle, String rcontent, String rnum)----------
	  
	  
	  // 리뷰글 삭제하기
	  @Override
	  public int deleteReview(String rnum) throws SQLException {
	  
	  int n = 0;
	  
	  try {
		  conn = ds.getConnection();
	  
		  String sql = " delete tbl_review " + " where rnum = ? ";
		  
		  pstmt = conn.prepareStatement(sql); 
		  pstmt.setString(1, rnum);
		  
		  n = pstmt.executeUpdate();
	  
	  } finally {
		  close(); 
	  }
	  
	  return n; 
	  }// end of public int deleteReview(String rnum)---------------------------------------------
	  
	  
	  // 리뷰글 삭제 후 목록에서 삭제 확인
	  @Override
	  public List<ReviewVO> deleteReviewEnd() throws SQLException {
	  
		  List<ReviewVO> reviewList = new ArrayList<>();
		  
		  try { 
			  
			  conn = ds.getConnection();
		  
			  String sql = " select rnum, rwriter, rtitle, rcontent, rdate "
					  	 + " from tbl_review ";
			  
			  pstmt = conn.prepareStatement(sql);
			  
			  rs = pstmt.executeQuery();
			  
			  while(rs.next()) {
			  
			  ReviewVO rvo = new ReviewVO();
			  
			  rvo.setRnum(rs.getInt(1)); 
			  rvo.setRwriter(rs.getString(2));
			  rvo.setRtitle(rs.getString(3));
			  rvo.setRcontent(rs.getString(4)); 
			  rvo.setRdate(rs.getDate(5));
			  
			  reviewList.add(rvo);
		  
		  }// end of while---------------------------
		  
		  } catch(SQLException e) { 
			  e.printStackTrace(); 
		  } finally { 
			  close(); 
		  }
		  
		  return reviewList; 
	  }// end of public List<ReviewVO> deleteReviewEnd()------------------------------------------------
  
  
  }
 