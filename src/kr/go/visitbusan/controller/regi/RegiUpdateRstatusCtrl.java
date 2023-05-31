package kr.go.visitbusan.controller.regi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.service.RegiService;
import kr.go.visitbusan.vo.RegistrationVO;

@WebServlet("/RegiUpdateRstatus.do")
public class RegiUpdateRstatusCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regId = request.getParameter("regId");
		
		RegiService rService = new RegiService();
		RegistrationVO regiVO = rService.RegiVOBYRegId(regId);
		request.setAttribute("list", regiVO);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/updateRstatus.jsp");
		view.forward(request, response);
	}
}