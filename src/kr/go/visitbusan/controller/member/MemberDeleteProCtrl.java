package kr.go.visitbusan.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.visitbusan.service.MemberService;

@WebServlet("/MemberDeletePro.do")
public class MemberDeleteProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");		
		MemberService mService = new MemberService();
		
		int cnt = mService.memberDelete(id);
		
		HttpSession ses = request.getSession();
		ses.invalidate();
		
		String msg = "";
		if(cnt==1){
			msg = "회원 탈퇴가 정상적으로 완료 되었습니다.";
			response.sendRedirect(request.getContextPath());
		} else {
			msg = "회원 탈퇴 처리가 실패되었습니다.";
			response.sendRedirect(request.getContextPath());
		}
		
	}
}
