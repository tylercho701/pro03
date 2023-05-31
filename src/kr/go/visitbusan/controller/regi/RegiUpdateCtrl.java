package kr.go.visitbusan.controller.regi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Visit;
import kr.go.visitbusan.service.VisitService;

@WebServlet("/RegiUpdate.do")
public class RegiUpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String visitId = request.getParameter("visitId");
		String regId = request.getParameter("regId");
		
		VisitService vService = new VisitService();
		Visit visit = vService.visitByVisitId(visitId);
		request.setAttribute("visit", visit);
		request.setAttribute("regId", regId);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/registration/regiUpdate.jsp");
		view.forward(request, response);
	}
}