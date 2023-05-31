package kr.go.visitbusan.controller.regi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.service.RegiService;

@WebServlet("/RegiDeletePro.do")
public class RegiDeleteProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regId = request.getParameter("regId");
		String sid = request.getParameter("sid");
		
		RegiService rService = new RegiService();
		int i = rService.DeleteRegi(regId);
		if (i>0){
			response.sendRedirect(request.getContextPath()+"/RegiListbyMemberId.do?sid="+sid);
		} else {
			response.sendRedirect("");
		}
	}
}