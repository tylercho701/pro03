package kr.go.visitbusan.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberTerms.do")
public class MemberTermsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "약관 동의 확인을 위해 약관 페이지로 이동";
		request.setAttribute("msg", msg);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/member/memberTerms.jsp");
		view.forward(request, response);
	}
}
