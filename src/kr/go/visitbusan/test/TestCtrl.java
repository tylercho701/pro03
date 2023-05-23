package kr.go.visitbusan.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test.do")
public class TestCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "테스트 페이지로 이동합니다.";
		
		request.setAttribute("msg", msg);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/member/memberMyPage.jsp");
		view.forward(request, response);
	}
}