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

@WebServlet("/QnaDetail.do")
public class QnaDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qId = request.getParameter("qId");
		
		QnAService qService = new QnAService();
		QnA qna = new QnA();
		
		qna = qService.qnADetail(qId);
		
		ArrayList<QnA> qListA = new ArrayList<QnA>();
		qListA = qService.qnAAnsweredListByQIdGroup(qna.getqIdGroup());
		
		ArrayList<QnA> qListQ = new ArrayList<QnA>();
		qListQ = qService.qnAQuestionListByQIdGroup(qna.getqIdGroup());
		
		request.setAttribute("qna", qna);
		request.setAttribute("qListA", qListA);
		request.setAttribute("qListQ", qListQ);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/qna/qnaDetail.jsp");
		view.forward(request, response);
	}
}