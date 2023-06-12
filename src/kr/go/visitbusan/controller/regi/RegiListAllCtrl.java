package kr.go.visitbusan.controller.regi;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.service.RegiService;
import kr.go.visitbusan.vo.RegistrationVO;


@WebServlet("/RegiListAll.do")
public class RegiListAllCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegiService rService = new RegiService();
		ArrayList<RegistrationVO> regiVOList = rService.AdminRegiVOListAll();
		request.setAttribute("regiVOList", regiVOList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/regiListAll.jsp");
		view.forward(request, response);
	}
}