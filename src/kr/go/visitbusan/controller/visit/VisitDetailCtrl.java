package kr.go.visitbusan.controller.visit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Visit;
import kr.go.visitbusan.service.VisitService;

@WebServlet("/VisitDetail.do")
public class VisitDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String visitId = request.getParameter("visitId");
		
		VisitService vService = new VisitService();
		Visit visit = vService.visitByVisitId(visitId);
		request.setAttribute("visit", visit);
		
/*		PokeService pService = new PokeService();
		int i = pService.CountPokeListByVisitId(visitId);
		request.setAttribute("count", i);*/
		
		if(visit != null){
			RequestDispatcher view = request.getRequestDispatcher("visit/visitDetail.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("");
		}
	}
}