package kr.go.visitbusan.controller.visit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Category;
import kr.go.visitbusan.service.CateService;

@WebServlet("/VisitInsert.do")
public class VisitInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		CateService cService = new CateService();
		ArrayList<Category> cateList = cService.CateListbyCateCode1();
		request.setAttribute("cateList", cateList);
		
		RequestDispatcher view = request.getRequestDispatcher("visit/visitInsert.jsp");
		view.forward(request, response);
	}
}