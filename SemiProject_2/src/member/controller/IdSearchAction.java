package member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractController;
import member.model.InterMemberDAO_PJW;
import member.model.MemberDAO_PJW;

public class IdSearchAction extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			
			
			String method = request.getMethod();
			// "GET" or "POST"
			
			if("POST".equalsIgnoreCase(method)) {
				// 아이디 찾기 모달창에서 찾기 버튼을 클릭했을 경우
				
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				
				
				InterMemberDAO_PJW mdao = new MemberDAO_PJW();
				
				Map<String, String> paraMap = new HashMap<>();
				paraMap.put("name", name);
				paraMap.put("email", email);
				
				
				String userid = mdao.findUserid(paraMap);
				
				if(userid != null) {
					request.setAttribute("userid", userid);
					
				}
				else {
					request.setAttribute("userid", "존재하지 않습니다.");
				}
				
				request.setAttribute("name", name);
				request.setAttribute("email", email);
				
			}// end of if("POST)-------------------------------------------------
				
			request.setAttribute("method", method);
			
			// super.setRedirect(false);
			super.setViewPage("/WEB-INF/login/idFind.jsp");

		}
		
	}

