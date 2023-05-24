package kr.go.visitbusan.controller.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.go.visitbusan.dto.Review;
import kr.go.visitbusan.service.ReviewService;

@WebServlet("/ReviewList.do")
public class ReviewListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService rService = new ReviewService();
		ArrayList<Review> revList = new ArrayList<Review>();
		
		revList = rService.reviewListAll();
		request.setAttribute("revList", revList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/review/reviewList.jsp");
		view.forward(request, response);
	}
}