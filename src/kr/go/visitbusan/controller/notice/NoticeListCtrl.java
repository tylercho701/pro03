package kr.go.visitbusan.controller.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Notice;
import kr.go.visitbusan.service.NoticeService;

@WebServlet("/NoticeList.do")
public class NoticeListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cPage = request.getParameter("cPage");
		int cur = 0;
		if(cPage!=null){
			cur = Integer.parseInt(cPage);
		} else {
			cur = 1;
		}
		
		NoticeService service = new NoticeService();
		/*ArrayList<Notice> notiList = service.getNoticePagingList(cur);*/
		
		/*request.setAttribute("list", notiList);*/
		
		RequestDispatcher view = request.getRequestDispatcher("/notice/notiList.jsp");
		view.forward(request, response);
	}
}