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
import kr.go.visitbusan.dto.Visit;
import kr.go.visitbusan.service.CateService;
import kr.go.visitbusan.service.VisitService;

@WebServlet("/VisitListbyCateCode.do")
public class VisitListbyCateCodeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리 해야 됨
		String cateCode = request.getParameter("cateCode");
		VisitService vService = new VisitService();
		ArrayList<Visit> visitList = vService.visitListByCateCode(cateCode);
		request.setAttribute("visitList", visitList);
		
		CateService cService = new CateService();
		Category cate = cService.CatebyCateCode(cateCode);
		request.setAttribute("cate", cate);
		
		if(visitList != null){
			RequestDispatcher view = request.getRequestDispatcher("visit/visitListbyCateCode.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("");
		}
	}
}