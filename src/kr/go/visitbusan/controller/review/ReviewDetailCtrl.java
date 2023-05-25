package kr.go.visitbusan.controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Review;
import kr.go.visitbusan.service.ReviewService;

@WebServlet("/ReviewDetail.do")
public class ReviewDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reviewId = request.getParameter("reviewId");
		ReviewService rService = new ReviewService();
		
		Review rev = rService.reviewDetail(reviewId);

		request.setAttribute("review", rev);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/review/reviewDetail.jsp");
		view.forward(request, response);
	}
}