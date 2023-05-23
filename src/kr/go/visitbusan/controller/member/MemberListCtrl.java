package kr.go.visitbusan.controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Member;
import kr.go.visitbusan.service.MemberService;

@WebServlet("/MemberList.do")
public class MemberListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "회원 목록에 접근합니다.";
		
		MemberService mService = new MemberService();
		ArrayList<Member> memList = new ArrayList<Member>();
		memList = mService.memberList();
		
		request.setAttribute("memList", memList);
		request.setAttribute("msg", msg);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/member/memberList.jsp");
		view.forward(request, response);
	}
}