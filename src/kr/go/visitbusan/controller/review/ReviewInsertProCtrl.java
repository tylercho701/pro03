package kr.go.visitbusan.controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Review;
import kr.go.visitbusan.service.ReviewService;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/ReviewInsertPro.do")
public class ReviewInsertProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/dataRev";		// 공지사항 첨부파일 저장 장소 정해야함
		int uploadFileSizeLimit = 10 * 1024 * 1024;	//1024 byte * 1024 byte = 1024kb * 10 = 10 mega byte
		String encType = "UTF-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);			// 확인용
		System.out.println("서버상에 실제 업로드되는 디렉토리 : "+uploadFilePath);		// 확인용
		
		String reviewTitle = "";
		String reviewContent = "";
		String reviewedBy = "";
		String visitId = "";
		String regid = "";
		int point = 0;
		String attImgName = "";
		
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			attImgName = multi.getFilesystemName("img"); // 업로드하고, 업로드된 파일의 이름 얻기
			if (attImgName == null) { // 파일이 업로드 되지 않았을때
				System.out.print("파일 업로드 실패~! / 첨부파일 없음");
			}  // 파일이 업로드 되었을때
			reviewTitle = multi.getParameter("reivewTitle");
			reviewContent = multi.getParameter("reviewContent");
			reviewedBy = multi.getParameter("reviewedBy");
			visitId = multi.getParameter("visitId");
			regid = multi.getParameter("regId");
			point = Integer.parseInt(multi.getParameter("point"));
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}
		
		ReviewService rService = new ReviewService();
		Review rev = new Review();
		rev.setReviewTitle(reviewTitle);
		rev.setReviewContent(reviewContent);
		rev.setReviewedBy(reviewedBy);
		rev.setVisitId(visitId);
		rev.setRegId(regid);
		rev.setPoint(point);
		rev.setImg(attImgName);
		int cnt = rService.reviewInsert(rev);	
		if(cnt==0){ //글쓰기 실패
			System.out.println("여행후기 등록 실패");
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/review/reviewInsert.jsp");
			view.forward(request, response);
		} else { //글쓰기 성공
			response.sendRedirect(request.getContextPath());		// 어디로 가야하죠 ... ?
		}
	}
}