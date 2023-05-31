package kr.go.visitbusan.controller.visit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.service.VisitService;

@WebServlet("/VisitDeletePro.do")
public class VisitDeleteProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String visitId = request.getParameter("visitId");
		
		VisitService vService = new VisitService();
		int i = vService.deleteVisit(visitId);
		if(i>0){
			response.sendRedirect(request.getContextPath()+"/VisitCtrl.do");
		} else{
			response.sendRedirect("");
		}
	}
}