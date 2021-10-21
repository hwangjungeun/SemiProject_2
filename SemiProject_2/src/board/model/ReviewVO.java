package board.model;

import java.sql.Date;

public class ReviewVO {

	private int    rnum; 	  // 리뷰글번호
	private String rtitle; 	  // 리뷰제목
	private String rwriter;   // 작성자
	private String rcontent;  // 리뷰내용
	private String rphoto;	  // 리뷰사진
	private Date   rdate;  	  // 리뷰등록일
	
	///////////////////////////////////////////
	
	public ReviewVO() {}
	
	public ReviewVO(String rtitle, String rwriter, String rcontent, String rphoto) {
	
	this.rtitle = rtitle;
	this.rwriter = rwriter;
	this.rcontent = rcontent; 
	this.rphoto = rphoto;
	}
	
	
	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getRtitle() {
		return rtitle;
	}
	
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	
	public String getRwriter() {
		return rwriter;
	}
	
	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}
	
	public String getRcontent() {
		return rcontent;
	}
	
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	
	public String getRphoto() {
		return rphoto;
	}
	
	public void setRphoto(String rphoto) {
		this.rphoto = rphoto;
	}
	
	public Date getRdate() {
		return rdate;
	}
	
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}



	
	
	
}
	
		