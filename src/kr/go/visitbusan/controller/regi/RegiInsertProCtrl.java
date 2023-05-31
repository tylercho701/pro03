package kr.go.visitbusan.controller.regi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Registration;
import kr.go.visitbusan.service.PokeService;
import kr.go.visitbusan.service.RegiService;

@WebServlet("/RegiInsertPro.do")
public class RegiInsertProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pokeId = request.getParameter("pokeId");
		
		Registration regi = new Registration();
		regi.setRegisteredBy(request.getParameter("registeredBy"));
		regi.setVisitId(request.getParameter("visitId"));
		regi.setTourDate(request.getParameter("tourDate"));
		
		RegiService rService = new RegiService();
		int i = rService.InsertRegi(regi);
		
		PokeService pService = new PokeService();
		int j = pService.DeletePoke(pokeId);
		
		if(i+j==2){
			response.sendRedirect(request.getContextPath()+"/RegiListbyMemberId.do?sid="+request.getParameter("registeredBy"));
		} else {
			response.sendRedirect("");
		}
	}
}