package kr.go.visitbusan.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.visitbusan.dto.Member;
import kr.go.visitbusan.service.MemberService;

@WebServlet("/MemberDetail.do")
public class MemberDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberService mService = new MemberService();
		Member mem = new Member();

		mem = mService.memberMyInfo(id);
		
		request.setAttribute("mem", mem);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/member/memberDetail.jsp");
		view.forward(request, response);
	}
}