package kr.go.visitbusan.controller.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.service.QnAService;

@WebServlet("/QnaDeleteQuestionPro.do")
public class QnaDeleteQuestionProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qId = request.getParameter("qId");
		QnAService qService = new QnAService();
		int cnt = 0;
		
		cnt = qService.qnADeleteByQIdGroup(qId);
		
		if(cnt==0){
			System.out.println("QnA 질문 및 답변 전체 삭제에 실패했습니다.");
			
			response.sendRedirect("QnaDetail.do?qId="+qId);
		} else {
			System.out.println("QnA 질문 및 답변 전체 삭제에 성공했습니다.");
			
			response.sendRedirect(request.getContextPath());
		}
	}
}