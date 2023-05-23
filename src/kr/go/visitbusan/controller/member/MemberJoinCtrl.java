package kr.go.visitbusan.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberJoin.do")
public class MemberJoinCtrl extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "약관 동의 확인 후 회원 가입 페이지로 이동";
		request.setAttribute("msg", msg);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/member/memberJoin.jsp");
		view.forward(request, response);
	}
}