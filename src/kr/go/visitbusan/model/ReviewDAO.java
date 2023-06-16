package kr.go.visitbusan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.visitbusan.dto.Review;
import kr.go.visitbusan.util.MySQL8;

public class ReviewDAO implements ReviewDAOInterface{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// Review 전체를 List로 출력
	public ArrayList<Review> reviewListAll(){
		ArrayList<Review> reviewList = new ArrayList<Review>();
		//notice 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 notiList에 add를 한다.
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.REVIEW_LIST_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Review rev = new Review();
				rev.setReviewId(rs.getString("reviewId"));
				rev.setReviewTitle(rs.getString("reviewTitle"));
				rev.setReviewContent(rs.getString("reviewContent"));
				rev.setReviewedAt(rs.getString("reviewedAt"));
				rev.setReviewedBy(rs.getString("reviewedBy"));
				rev.setVisitId(rs.getString("VisitId"));
				rev.setRegId(rs.getString("RegId"));
				rev.setPoint(rs.getInt("point"));
				rev.setImg(rs.getString("img"));
				rev.setLikeCnt(rs.getInt("likeCnt"));
				reviewList.add(rev);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt, rs);
		return reviewList;
	}
	
	// review like + 1
	public int reviewUpdateLikeCnt(String reviewId) {
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.REVIEW_UPDATE_LIKECNT);
			pstmt.setString(1, reviewId);

			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();			
		} catch (Exception e){
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt);
		return cnt;
	}
	
	// Insert Review
	public int reviewInsert(Review rev){
		int cnt = 0;
		String ReviewId = reviewIdGenerator();			//noticeId 생성 (가장 최근 noticeId + 1)
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.REVIEW_INSERT);
			pstmt.setString(1, ReviewId);
			pstmt.setString(2, rev.getReviewTitle());
			pstmt.setString(3, rev.getReviewContent());
			pstmt.setString(4, rev.getReviewedBy());
			pstmt.setString(5, rev.getVisitId());
			pstmt.setString(6, rev.getRegId());
			pstmt.setInt(7, rev.getPoint());
			pstmt.setString(8, rev.getImg());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();			
		} catch (Exception e){
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt);
		return cnt;
	}
	
	// NoticeId 생성기
	public String reviewIdGenerator(){
		String reviewId = "";
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.REVIEW_REVIEWID_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				reviewId = rs.getString("reviewId");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}
		
		int tmp = Integer.parseInt(reviewId) + 1;
		reviewId = tmp + "";
		return reviewId;
	}
	
	// Notice Update
	public Review reviewUpdate(String reviewId){
		Review rev = new Review();
		// reviewId를 매개변수로 해당 공지 사항의 내용을 rev에 저장
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.REVIEW_DETAIL);
			pstmt.setString(1, reviewId);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				rev.setReviewId(rs.getString("reviewId"));
				rev.setReviewTitle(rs.getString("reviewTitle"));
				rev.setReviewContent(rs.getString("reviewContent"));
				rev.setReviewedAt(rs.getString("reviewedAt"));
				rev.setReviewedBy(rs.getString("reviewedBy"));
				rev.setVisitId(rs.getString("VisitId"));
				rev.setRegId(rs.getString("RegId"));
				rev.setPoint(rs.getInt("pointt"));
				rev.setImg(rs.getString("img"));
				rev.setLikeCnt(rs.getInt("likeCnt"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();			
		} catch (Exception e){
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt, rs);
		return rev;
	}
		
	// Notice Update
	public int reviewUpdatePro(Review rev) {
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			if(rev.getImg()==null) {				// 첨부 파일이 변경되지 않는 경우
				pstmt = conn.prepareStatement(MySQL8.REVIEW_UPDATE_NOT_CHANGED_IMG);
				pstmt.setString(1, rev.getReviewTitle());
				pstmt.setString(2, rev.getReviewContent());
				pstmt.setString(3, rev.getReviewId());
			} else {								// 첨부 파일이 변경되는 경우
				pstmt = conn.prepareStatement(MySQL8.REVIEW_UPDATE_CHANGED_IMG);
				pstmt.setString(1, rev.getReviewTitle());
				pstmt.setString(2, rev.getReviewContent());
				pstmt.setString(3, /* 첨부파일 폴더명 미정 */""+rev.getImg());
				pstmt.setString(4, rev.getReviewId());
			}
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt);
		return cnt;
	}

	public int reviewDelete(String reviewId) {
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.REVIEW_DELETE);
			pstmt.setString(1, reviewId);

			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();			
		} catch (Exception e){
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt);
		return cnt;
	}
	
	public Review reviewDetail(String reviewId){
		Review rev = new Review();
		
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.REVIEW_DETAIL);
			pstmt.setString(1, reviewId);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				rev.setReviewId(rs.getString("reviewId"));
				rev.setReviewTitle(rs.getString("reviewTitle"));
				rev.setReviewContent(rs.getString("reviewContent"));
				rev.setReviewedAt(rs.getString("reviewedAt"));
				rev.setReviewedBy(rs.getString("reviewedBy"));
				rev.setVisitId(rs.getString("VisitId"));
				rev.setRegId(rs.getString("RegId"));
				rev.setPoint(rs.getInt("point"));
				rev.setImg(rs.getString("img"));
				rev.setLikeCnt(rs.getInt("likeCnt"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();			
		} catch (Exception e){
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt, rs);
		return rev;
	}

	//	review data 중 likeCnt 내림차순 3개
	@Override
	public ArrayList<Review> reviewRank() {
		ArrayList<Review> reviewList = new ArrayList<Review>();
		try {
		conn = MySQL8.getConnection();
		pstmt = conn.prepareStatement(MySQL8.RANK_REVIEW_TOP_3);
		rs = pstmt.executeQuery();
		while(rs.next()){
			Review rev = new Review();
			rev.setReviewedBy(rs.getString("reviewedBy"));
			rev.setLikeCnt(rs.getInt("likeCnt"));
			reviewList.add(rev);
		}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();			
		} catch (Exception e){
			e.printStackTrace();
		}
		return reviewList;
	}

	@Override
	public ArrayList<Review> reviewListByVisit(String visitId) {
		ArrayList<Review> reviewList = new ArrayList<Review>();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.REVIEW_LIST_BY_VISITID);
			pstmt.setString(1, visitId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Review rev = new Review();
				rev.setReviewId(rs.getString("reviewId"));
				rev.setReviewTitle(rs.getString("reviewTitle"));
				rev.setReviewContent(rs.getString("reviewContent"));
				rev.setReviewedAt(rs.getString("reviewedAt"));
				rev.setReviewedBy(rs.getString("reviewedBy"));
				rev.setVisitId(rs.getString("VisitId"));
				rev.setRegId(rs.getString("RegId"));
				rev.setPoint(rs.getInt("point"));
				rev.setImg(rs.getString("img"));
				rev.setLikeCnt(rs.getInt("likeCnt"));
				reviewList.add(rev);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt, rs);
		return reviewList;
	}	
}
