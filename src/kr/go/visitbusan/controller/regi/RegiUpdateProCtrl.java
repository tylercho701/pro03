package kr.go.visitbusan.controller.regi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Registration;
import kr.go.visitbusan.service.RegiService;

@WebServlet("/RegiUpdatePro.do")
public class RegiUpdateProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regId = request.getParameter("regId");
		String sid = request.getParameter("sid");
		
		Registration regi = new Registration();
		regi.setTourDate(request.getParameter("tourDate"));
		regi.setRegId(regId);
		
		RegiService rService = new RegiService();
		int i = rService.UpdateRegi(regi);
		
		if(i>0){
			response.sendRedirect(request.getContextPath()+"/RegiListbyMemberId.do?sid="+sid);
		} else {
			response.sendRedirect("");
		}
	}
}