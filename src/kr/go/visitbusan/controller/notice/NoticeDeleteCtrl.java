package kr.go.visitbusan.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.service.NoticeService;

@WebServlet("/NoticeDelete.do")
public class NoticeDeleteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		String noticeId = request.getParameter("noticeId");
		NoticeService nService = new NoticeService();
		int cnt = nService.noticeDelete(noticeId);
		
		if(cnt == 1){
			msg = "공지글 삭제에 성공했습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("NoticeList.do");
		} else {
			msg = "공지글 삭제에 실패했습니다.";
			request.setAttribute("msg", msg);
			response.sendRedirect("NoticeDetail.do?noticeId="+noticeId);
		}
	}
}