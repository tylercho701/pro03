package kr.go.visitbusan.controller.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.QnA;
import kr.go.visitbusan.service.QnAService;

@WebServlet("/QnAList.do")
public class QnAListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<QnA> qList = new ArrayList<>();
		QnAService qService = new QnAService();
		
		qList = qService.qnAListAll();
		
		request.setAttribute("qList", qList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/qna/qnaList.jsp");
		view.forward(request, response);
	}
}