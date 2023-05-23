package kr.go.visitbusan.controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Notice;
import kr.go.visitbusan.service.NoticeService;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/NoticeInsertPro.do")
public class NoticeInsertProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/data";		// 공지사항 첨부파일 저장 장소 정해야함
		int uploadFileSizeLimit = 10 * 1024 * 1024;	//1024 byte * 1024 byte = 1024kb * 10 = 10 mega byte
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);			// 확인용
		System.out.println("서버상에 실제 업로드되는 디렉토리 : "+uploadFilePath);		// 확인용
		
		String noticeTitle = "";
		String noticeContent = "";
		String writtenBy = "";
		String attFileName = "";
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			attFileName = multi.getFilesystemName("attachment"); // 업로드하고, 업로드된 파일의 이름 얻기
			if (attFileName == null) { // 파일이 업로드 되지 않았을때
				System.out.print("파일 업로드 실패~! / 첨부파일 없음");
			}  // 파일이 업로드 되었을때
			writtenBy = multi.getParameter("writtenBy");
			noticeTitle = multi.getParameter("noticeTitle");
			noticeContent = multi.getParameter("noticeContent");
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}
		
		NoticeService nService = new NoticeService();
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		notice.setAttachment(attFileName);
		notice.setWrittenBy(writtenBy);
		int cnt = nService.noticeInsert(notice);	
		if(cnt==0){ //글쓰기 실패
			String msg = "공지사항을 글이 등록되지 못했습니다.";
			request.setAttribute("msg", msg);
			
			//디스패치로 view를 생성하여 noticeList.jsp로 요청 받은 notiList를 포워드
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/notice/noticeInsert.jsp");
			view.forward(request, response);
		} else { //글쓰기 성공
			response.sendRedirect("NoticeList.do");
		}
	}
}