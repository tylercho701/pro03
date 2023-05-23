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

@WebServlet("/MemberUpdate.do")
public class MemberUpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberService mService = new MemberService();
		Member mem = new Member();
		String msg = "";

		mem = mService.memberMyInfo(id);
		
		msg = "현재 본인 정보를 로딩하였습니다.";
		request.setAttribute("mem", mem);
		request.setAttribute("msg", msg);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/member/memberUpdate.jsp");
		view.forward(request, response);
	}
}