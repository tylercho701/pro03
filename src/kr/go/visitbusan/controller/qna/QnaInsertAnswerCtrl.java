package kr.go.visitbusan.controller.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.QnA;
import kr.go.visitbusan.service.QnAService;

@WebServlet("/QnaInsertAnswer.do")
public class QnaInsertAnswerCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qId = request.getParameter("qId");
		QnAService qService = new QnAService();
		
		QnA qna = new QnA();
		qna = qService.qnADetail(qId);
		
		request.setAttribute("qna", qna);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/qna/qnaInsertAnswer.jsp");
		view.forward(request, response);
	}
}
