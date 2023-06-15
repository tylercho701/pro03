package kr.go.visitbusan.model;

import java.util.ArrayList;

import kr.go.visitbusan.dto.Review;

public interface ReviewDAOInterface {
	public ArrayList<Review> reviewListAll();
	public int reviewUpdateLikeCnt(String reviewId);
	public int reviewInsert(Review rev);
	public String reviewIdGenerator();
	public Review reviewUpdate(String reviewId);
	public int reviewUpdatePro(Review rev);
	public int reviewDelete(String reviewId);
	public Review reviewDetail(String reviewId);
	public ArrayList<Review> reviewRank();
}