package kr.go.visitbusan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.visitbusan.dto.QnA;
import kr.go.visitbusan.util.MySQL8;

public class QnADAO implements QnADAOInterface {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// QnA 전체를 List로 출력
	public ArrayList<QnA> qnAListAll(){
		ArrayList<QnA> qnAList = new ArrayList<QnA>();
		//notice 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 notiList에 add를 한다.
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.QNA_LIST_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				QnA qna = new QnA();
				qna.setqId(rs.getString("qId"));
				qna.setqTitle(rs.getString("qTitle"));
				qna.setqContent(rs.getString("qContent"));
				qna.setqType(rs.getInt("qType"));
				qna.setqIdGroup(rs.getString("qIdGroup"));
				qna.setAskedAt(rs.getString("askedAt"));
				qna.setAskedBy(rs.getString("askedBy"));
				qna.setReadCnt(rs.getInt("readCnt"));
				qnAList.add(qna);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt, rs);
		return qnAList;
	}
	
	// QnA 전체 중 질문-답변을 묶은 List 출력 by qIdGroup
		public ArrayList<QnA> qnAListByQIdGroup(String qIdGroup){
			ArrayList<QnA> qnAList = new ArrayList<QnA>();
			//notice 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 notiList에 add를 한다.
			try {
				conn = MySQL8.getConnection();
				pstmt = conn.prepareStatement(MySQL8.QNA_LIST_BY_QIDGROUP);
				pstmt.setString(1, qIdGroup);
				rs = pstmt.executeQuery();
				while(rs.next()){
					QnA qna = new QnA();
					qna.setqId(rs.getString("qId"));
					qna.setqTitle(rs.getString("qTitle"));
					qna.setqContent(rs.getString("qContent"));
					qna.setqType(rs.getInt("qType"));
					qna.setqIdGroup(rs.getString("qIdGroup"));
					qna.setAskedAt(rs.getString("askedAt"));
					qna.setAskedBy(rs.getString("askedBy"));
					qna.setReadCnt(rs.getInt("readCnt"));
					qnAList.add(qna);
				}
			} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
				e.printStackTrace();
			} catch (SQLException e){	//sql 구문이 틀린 경우 발생
				e.printStackTrace();			
			} catch (Exception e){	//알 수 없는 예외인 경우 발생
				e.printStackTrace();
			}
			MySQL8.close(conn, pstmt, rs);
			return qnAList;
		}
		
	// QnA Detail
		public QnA qnADetail(String qId){
			qnaUpdateReadCnt(qId);
			QnA qna = new QnA();
			//notice 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 notiList에 add를 한다.
			try {
				conn = MySQL8.getConnection();
				pstmt = conn.prepareStatement(MySQL8.QNA_LIST_DETAIL);
				pstmt.setString(1, qId);
				rs = pstmt.executeQuery();
				if(rs.next()){
					qna.setqId(rs.getString("qId"));
					qna.setqTitle(rs.getString("qTitle"));
					qna.setqContent(rs.getString("qContent"));
					qna.setqType(rs.getInt("qType"));
					qna.setqIdGroup(rs.getString("qIdGroup"));
					qna.setAskedAt(rs.getString("askedAt"));
					qna.setAskedBy(rs.getString("askedBy"));
					qna.setReadCnt(rs.getInt("readCnt"));
				}
			} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
				e.printStackTrace();
			} catch (SQLException e){	//sql 구문이 틀린 경우 발생
				e.printStackTrace();			
			} catch (Exception e){	//알 수 없는 예외인 경우 발생
				e.printStackTrace();
			}
			MySQL8.close(conn, pstmt, rs);
			return qna;
		}
	
	// ReadCnt + 1
	public void qnaUpdateReadCnt(String qId){
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.QNA_UPDATE_READCNT);
			pstmt.setString(1, qId);
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
	public int qnAInsertQ(QnA qna){
		int cnt = 0;
		String qId = qIdGenerator();			//qId 생성 (가장 최근 qId + 1)
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.QNA_INSERT_Q);
			pstmt.setString(1, qId);
			pstmt.setString(2, qna.getqTitle());
			pstmt.setString(3, qna.getqContent());
			pstmt.setString(4, "1");			// 질문(Q)은 1, 답변(A)은 2
			pstmt.setString(5, qId);			// 질문(Q)의 qIdGroup은 해당 질문의 qId와 동일, 답변(A)은 해당 질문의 qId를 qIdGroup으로 사용함
			pstmt.setString(6, qna.getAskedBy());
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
	public String qIdGenerator(){
		String qId = "";
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.QNA_QID_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				qId = rs.getString("qId");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}
		
		int tmp = Integer.parseInt(qId) + 1;
		qId = tmp + "";
		return qId;
	}
	
	public int qnAInsertA(QnA qna){
		int cnt = 0;
		String qId = qIdGenerator();					//qId 생성 (가장 최근 qId + 1)
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.QNA_INSERT_A);
			pstmt.setString(1, qId);
			pstmt.setString(2, qna.getqTitle());
			pstmt.setString(3, qna.getqContent());
			pstmt.setString(4, "2");					// 질문(Q)은 1, 답변(A)은 2
			pstmt.setString(5, qna.getqIdGroup());		// 질문(Q)의 qIdGroup은 해당 질문의 qId와 동일, 답변(A)은 해당 질문의 qId를 qIdGroup으로 사용함
			pstmt.setString(6, qna.getAskedBy());
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
	
	// Notice Update
	public QnA qnAUpdate(String qId){
		QnA qna = new QnA();
		//qId를 매개변수로 해당 공지 사항의 내용을qna에 저장
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.QNA_LIST_DETAIL);
			pstmt.setString(1, qId);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				qna.setqId(rs.getString("qId"));
				qna.setqTitle(rs.getString("qTitle"));
				qna.setqContent(rs.getString("qContent"));
				qna.setqType(rs.getInt("qType"));
				qna.setqIdGroup(rs.getString("qIdGroup"));
				qna.setAskedAt(rs.getString("askedAt"));
				qna.setAskedBy(rs.getString("askedBy"));
				qna.setReadCnt(rs.getInt("readCnt"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();			
		} catch (Exception e){
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt, rs);
		return qna;
	}
		
	// QNA 수정
	public int qnAUpdatePro(QnA qna) {
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.QNA_UPDATE);
			pstmt.setString(1, qna.getqTitle());
			pstmt.setString(2, qna.getqContent());
			pstmt.setString(3, qna.getqId());
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

	// QNA Delete - QNA qIdGroupd 기준으로 전체 삭제
	public int qnADeleteByQIdGroup(String qIdGroup) {
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.QNA_DELETE_ALL_BY_QIDGROUP);
			pstmt.setString(1, qIdGroup);

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
	
	// QNA 답변만 삭제
	public int qnADeleteOnlyAnswer(String qId) {
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.QNA_DELETE_REPLY);
			pstmt.setString(1, qId);

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

	@Override
	public ArrayList<QnA> qnAAnsweredListByQIdGroup(String qIdGroup) {
		ArrayList<QnA> qnAList = new ArrayList<QnA>();
		//notice 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 notiList에 add를 한다.
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.QNA_LIST_FORANSWER_BY_QIDGROUP);
			pstmt.setString(1, qIdGroup);
			rs = pstmt.executeQuery();
			while(rs.next()){
				QnA qna = new QnA();
				qna.setqId(rs.getString("qId"));
				qna.setqTitle(rs.getString("qTitle"));
				qna.setqContent(rs.getString("qContent"));
				qna.setqType(rs.getInt("qType"));
				qna.setqIdGroup(rs.getString("qIdGroup"));
				qna.setAskedAt(rs.getString("askedAt"));
				qna.setAskedBy(rs.getString("askedBy"));
				qna.setReadCnt(rs.getInt("readCnt"));
				qnAList.add(qna);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt, rs);
		return qnAList;
	}

	@Override
	public ArrayList<QnA> qnAQuestionListByQIdGroup(String qIdGroup) {
		ArrayList<QnA> qnAList = new ArrayList<QnA>();
		//notice 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 notiList에 add를 한다.
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.QNA_LIST_FORQUESTION_BY_QIDGROUP);
			pstmt.setString(1, qIdGroup);
			rs = pstmt.executeQuery();
			while(rs.next()){
				QnA qna = new QnA();
				qna.setqId(rs.getString("qId"));
				qna.setqTitle(rs.getString("qTitle"));
				qna.setqContent(rs.getString("qContent"));
				qna.setqType(rs.getInt("qType"));
				qna.setqIdGroup(rs.getString("qIdGroup"));
				qna.setAskedAt(rs.getString("askedAt"));
				qna.setAskedBy(rs.getString("askedBy"));
				qna.setReadCnt(rs.getInt("readCnt"));
				qnAList.add(qna);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		MySQL8.close(conn, pstmt, rs);
		return qnAList;
	}
	
}
