package kr.go.visitbusan.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.visitbusan.service.MemberService;

@WebServlet("/MemberLoginPro.do")
public class MemberLoginProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberService mService = new MemberService();
		int cnt = 0;
		
		cnt = mService.memberLogin(id, pw);

		HttpSession ses = request.getSession();
		String msg = "";
		if(cnt==1){
			msg = "로그인 성공";
			ses.setAttribute("sid", id);
			response.sendRedirect(request.getContextPath());
		} else if(cnt==9){
			msg = "아이디 또는 비밀번호가 틀립니다.";
			response.sendRedirect("MemberLogin.do");	
		} else {
			msg = "존재하지 않는 아이디입니다.";
			response.sendRedirect("MemberLogin.do");
		}
	}
}