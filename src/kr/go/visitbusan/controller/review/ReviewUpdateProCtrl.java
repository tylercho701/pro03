package kr.go.visitbusan.controller.review;

import java.io.IOException;

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

@WebServlet("/ReviewUpdatePro.do")
public class ReviewUpdateProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String savePath = "/dataRev";								//업로드할 디렉토리
		int uploadFileSizeLimit = 10 * 1024 * 1024;				//업로드할 파일 크기 제한
		String encType = "UTF-8";								//멀티파트 데이터의 인코딩 설정
		ServletContext context = getServletContext();			//현재 서블릿(프로젝트)의 위치 저장
		String uploadFilePath = context.getRealPath(savePath);  //서버 상에 실제 업로드되는 디렉토리 지정
		System.out.println("지정된 업로드 디렉토리 : "+savePath);
		System.out.println("서버 상의 실제 업로드되는 디렉토리 : "+uploadFilePath);
		
		String reviewTitle = "";
		String reviewContent = "";
		String attImgName = "";
		String reviewId = "";
		//MultipartRequest의 옵션 내용
		//1. request : 요청 받은 객체
		//2. uploadFilePath : 서버상의 실제 디렉토리
		//3. uploadFileSizeLimit : 최대 업로드 파일 크기
		//4. encType : 인코딩 방법
		//5. new DefaultFileRenamePolicy() : 동일한 이름이 존재하면 새로운 이름이 부여되며, 생략하면, 덮어쓰기 됨
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, 
					uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			attImgName = multi.getFilesystemName("img"); // 업로드하고, 업로드된 파일의 이름 얻기
			if (attImgName == null) { // 파일이 업로드 되지 않았을때
				System.out.print("파일 업로드 실패~! / 첨부파일 없음");
			}  // 파일이 업로드 되었을때
			reviewTitle = multi.getParameter("reviewTitle");
			reviewContent = multi.getParameter("reviewContent");
			reviewId = multi.getParameter("reviewId");
			
		} catch (Exception e) {
			System.out.print("예외 발생 : " + e);
		}
		
		ReviewService rService = new ReviewService();
		Review rev = new Review();
		rev.setReviewTitle(reviewTitle);
		rev.setReviewContent(reviewContent);
		rev.setImg(attImgName);
		rev.setReviewId(reviewId);
		int cnt = rService.reviewUpdatePro(rev);
		if(cnt==0){ //글 수정 실패
			System.out.println("여행 후기 수정이 실패했습니다.");
			
			response.sendRedirect("ReivewUpdate.do?reviewId="+rev.getReviewId());
		} else { //수정이 성공하면 글 목록으로 이동
			System.out.println("여행 후기 수정이 성공했습니다.");
			
			response.sendRedirect(request.getContextPath());		// 어디로 갈까요 ... ?
		}
	}
}