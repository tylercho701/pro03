package kr.go.visitbusan.controller.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.QnA;
import kr.go.visitbusan.service.QnAService;

@WebServlet("/QnaInsertAnswerPro.do")
public class QnaInsertAnswerProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		QnA qna = new QnA();
		QnAService qService = new QnAService();
		
		qna.setqTitle(request.getParameter("qTitle"));
		qna.setqContent(request.getParameter("qContent"));
		qna.setqIdGroup(request.getParameter("qIdGroup"));
		
		int cnt = qService.qnAInsertA(qna);
		
		if(cnt == 0){
			System.out.println("질문 등록 실패");
			response.sendRedirect("QnAInsertQuestion.do?qId="+request.getParameter("qIdGroup"));
		} else {
			System.out.println("질문 등록 성공");
			response.sendRedirect("QnaList.do");
		}
		
		
	}
}