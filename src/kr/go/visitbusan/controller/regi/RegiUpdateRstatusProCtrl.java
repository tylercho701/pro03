package kr.go.visitbusan.controller.regi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Registration;
import kr.go.visitbusan.service.RegiService;

@WebServlet("/RegiUpdateRstatusPro.do")
public class RegiUpdateRstatusProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String regId = request.getParameter("regId");
		
		Registration regi = new Registration();
		regi.setTourDate(request.getParameter("tourDate"));
		regi.setrStatus(request.getParameter("rStatus"));
		regi.setRegId(regId);
		
		RegiService rService = new RegiService();
		int i = rService.UpdateRstatus(regi);
		
		if(i>0){
			response.sendRedirect(request.getContextPath()+"/RegiListAll.do");
		} else {
			response.sendRedirect("");
		}
	}
}