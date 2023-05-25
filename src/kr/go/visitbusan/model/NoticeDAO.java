package kr.go.visitbusan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.visitbusan.dto.Notice;
import kr.go.visitbusan.util.MySQL8;

public class NoticeDAO implements NoticeDAOInterface{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// Notice 전체를 List로 출력
	public ArrayList<Notice> noticeListAll(){
		ArrayList<Notice> notiList = new ArrayList<Notice>();
		//notice 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 notiList에 add를 한다.
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.NOTICE_LIST_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Notice noti = new Notice();
				noti.setNoticeId(rs.getString("noticeId"));
				noti.setNoticeTitle(rs.getString("noticeTitle"));
				noti.setNoticeContent(rs.getString("noticeContent"));
				noti.setWrittenAt(rs.getString("writtenAt"));
				noti.setWrittenBy(rs.getString("writtenBy"));
				noti.setAttachment(rs.getString("attachment"));
				noti.setReadCnt(rs.getInt("readcnt"));
				notiList.add(noti);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt, rs);
		return notiList;
	}
	
	// Notice 한 건의 상세 조회, ReadCnt + 1
	public Notice noticeDetail(String noticeId){
		noticeUpdateReadCnt(noticeId);
		Notice noti = new Notice();
		//noticeId를 매개변수로 해당 공지 사항의 내용을 noti에 저장
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.NOTICE_DETAIL);
			pstmt.setString(1, noticeId);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				noti.setNoticeId(rs.getString("noticeId"));
				noti.setNoticeTitle(rs.getString("noticeTitle"));
				noti.setNoticeContent(rs.getString("noticeContent"));
				noti.setWrittenAt(rs.getString("writtenAt"));
				noti.setWrittenBy(rs.getString("writtenBy"));
				noti.setAttachment(rs.getString("attachment"));
				noti.setReadCnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt, rs);
		return noti;
	}
	
	// ReadCnt + 1
	public void noticeUpdateReadCnt(String noticeId){
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.NOTICE_UPDATE_READCNT);
			pstmt.setString(1, noticeId);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt);
	}
	
	// Insert Notice
	public int noticeInsert(Notice noti){
		int cnt = 0;
		String noticeId = noticeIdGenerator();			//noticeId 생성 (가장 최근 noticeId + 1)
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.NOTICE_INSERT);
			pstmt.setString(1, noticeId);
			pstmt.setString(2, noti.getNoticeTitle());
			pstmt.setString(3, noti.getNoticeContent());
			pstmt.setString(4, noti.getWrittenBy());
			pstmt.setString(5, noti.getAttachment());
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
	public String noticeIdGenerator(){
		String noticeId = "";
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.NOTICE_NOTICEID_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				noticeId = rs.getString("noticeId");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}
		
		int tmp = Integer.parseInt(noticeId) + 1;
		noticeId = tmp + "";
		return noticeId;
	}
	
	// Notice Update
	public Notice noticeUpdate(String noticeId){
		Notice noti = new Notice();
		//noticeId를 매개변수로 해당 공지 사항의 내용을 noti에 저장
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.NOTICE_DETAIL);
			pstmt.setString(1, noticeId);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				noti.setNoticeId(rs.getString("noticeId"));
				noti.setNoticeTitle(rs.getString("noticeTitle"));
				noti.setNoticeContent(rs.getString("noticeContent"));
				noti.setWrittenAt(rs.getString("writtenAt"));
				noti.setWrittenBy(rs.getString("writtenBy"));
				noti.setAttachment(rs.getString("attachment"));
				noti.setReadCnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();			
		} catch (Exception e){
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt, rs);
		return noti;
	}
		

	public int noticeUpdatePro(Notice noti) {
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			if(noti.getAttachment()==null) {
				pstmt = conn.prepareStatement(MySQL8.NOTICE_UPDATE_NOT_CHANGED_ATTACHMENT);
				pstmt.setString(1, noti.getNoticeTitle());
				pstmt.setString(2, noti.getNoticeContent());
				pstmt.setString(3, noti.getNoticeId());
			} else {
				pstmt = conn.prepareStatement(MySQL8.NOTICE_UPDATE_CHANGED_ATTACHMENT);
				pstmt.setString(1, noti.getNoticeTitle());
				pstmt.setString(2, noti.getNoticeContent());
				pstmt.setString(3, /* 첨부파일 폴더명 미정 */""+noti.getAttachment());
				pstmt.setString(4, noti.getNoticeId());
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

	public int noticeDelete(String noticeId) {
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.NOTICE_DELETE);
			pstmt.setString(1, noticeId);

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
}
