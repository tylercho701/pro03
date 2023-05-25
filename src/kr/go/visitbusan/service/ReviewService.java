package kr.go.visitbusan.service;

import java.util.ArrayList;

import kr.go.visitbusan.dto.Review;
import kr.go.visitbusan.model.ReviewDAO;
import kr.go.visitbusan.model.ReviewDAOInterface;

public class ReviewService {
	ReviewDAOInterface dao = new ReviewDAO();
	
	public ArrayList<Review> reviewListAll(){
		ArrayList<Review> revList = dao.reviewListAll();
		return revList;
	};
	public int reviewUpdateLikeCnt(String reviewId){
		int cnt = dao.reviewUpdateLikeCnt(reviewId);
		return cnt;
	}
	public int reviewInsert(Review rev){
		int cnt = dao.reviewInsert(rev);
		return cnt;
	}
	public String reviewIdGenerator(){
		String reviewId = dao.reviewIdGenerator();
		return reviewId;
	}
	public Review reviewUpdate(String reviewId){
		Review rev = dao.reviewUpdate(reviewId);
		return rev;
	}
	public int reviewUpdatePro(Review rev){
		int cnt = dao.reviewUpdatePro(rev);
		return cnt;
	}
	public int reviewDelete(String reviewId){
		int cnt = dao.reviewDelete(reviewId);
		return cnt;
	}
	public Review reviewDetail(String reviewId){
		Review rev = dao.reviewDetail(reviewId);
		return rev;
	}
}