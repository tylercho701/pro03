package kr.go.visitbusan.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QnaInsertQuestion.do")
public class QnaInsertQuestionCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String askedBy = request.getParameter("askedBy");
		System.out.println(askedBy);
		
		request.setAttribute("askedBy", askedBy);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/qna/qnaQuestionInsert.jsp");
		view.forward(request, response);
	}
}
