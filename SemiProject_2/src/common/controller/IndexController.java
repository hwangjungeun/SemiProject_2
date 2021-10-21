package common.controller;


import javax.servlet.http.*;

public class IndexController extends AbstractController {
	// 부모 클래스를 AbstractController로 쓰겠다

	
/*	
	@Override
	public String toString() {
		return "### 클래스 IndexController의 인스턴스 메소드 toString() 호출됨  ###";
	}
*/
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// IndexController 클래스 인스턴스 메소드
		
//		System.out.println("### IndexController 클래스의 execute() 메소드 호출됨 ### ");
		
		super.getBasketCnt(request);// 다른 페이지들도 다 넣어야지 장바구니 갯수 볼 수 있음 !!
		super.setViewPage("/WEB-INF/index.jsp");	// /WEB-INF/main.up
		
	}
	
	
}
