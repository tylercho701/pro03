package kr.go.visitbusan.controller.notice;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Notice;
import kr.go.visitbusan.service.NoticeService;

@WebServlet("/NoticeDetail.do")
public class NoticeDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeId = request.getParameter("noticeId");
		
		NoticeService nService = new NoticeService();
		Notice notice = nService.noticeDetail(noticeId);
		String attachment1 = notice.getAttachment().substring(5); 
		String attachmentPath1 = notice.getAttachment().substring(0,4);
		
		attachment1 = URLEncoder.encode(attachment1, "UTF-8");	
		
		request.setAttribute("attachment1", attachment1);
		request.setAttribute("attachmentPath1", attachmentPath1);
		request.setAttribute("notice", notice);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/noticeDetail.jsp");
		view.forward(request, response);
	}
}