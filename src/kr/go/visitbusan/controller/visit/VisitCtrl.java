package kr.go.visitbusan.controller.visit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.service.VisitService;
import kr.go.visitbusan.vo.VisitVO;

@WebServlet("/VisitCtrl.do")
public class VisitCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리 해야 됨
		VisitService vService = new VisitService();
		ArrayList<VisitVO> visitVOList = vService.getVisitVO();
		request.setAttribute("visitVOList", visitVOList);
		
		
		if(visitVOList != null){
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/admin/visitCtrl.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("");
		}
	}
}