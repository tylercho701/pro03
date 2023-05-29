package kr.go.visitbusan.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.service.ReviewService;

@WebServlet("/ReviewDeletePro.do")
public class ReviewDeleteProCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reviewId = request.getParameter("reviewId");
		ReviewService rService = new ReviewService();
		
		int cnt = rService.reviewDelete(reviewId);
		
		if(cnt==0){
			System.out.println("여행 후기 삭제에 실패했습니다.");
			
			response.sendRedirect("reviewList.do");
		} else {
			System.out.println("여행 후기 삭제에 성공했습니다.");
			
			response.sendRedirect("ReviewList.do");
		}
	}
}