package kr.go.visitbusan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL8 {
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/busan?serverTimezone=Asia/Seoul";
	static String user = "root";
	static String pw = "1234";
	
	//sample
	public final static String SELECT_SAMPLE_ALL = "SELECT * FROM SAMPLE1 order by item3 desc";
	public final static String SELECT_SAMPLE_ONE = "SELECT * FROM SAMPLE1 WHERE ITEM1=? order by item3 desc";
	public final static String INSERT_SAMPLE = "INSERT INTO SAMPLE1 VALUES(?, ?, DEFAULT)";
	public final static String UPDATE_SAMPLE = "UPDATE SAMPLE1 SET ITEM2=? WHERE ITEM1=?";
	public final static String DELETE_SAMPLE = "DELETE FROM SAMPLE1 WHERE ITEM1=?";
	
	
	// MEMBER
	public final static String MEMBER_LIST_ALL = "select * from member order by id asc;";
	public final static String MEMBER_LOGIN = "select * from member where id = ?;";
	public final static String MEMBER_UPDATE_LOGCNT = "update member set logcnt = logcnt + 1 where id = ?";
	public final static String MEMBER_INSERT = "insert into member(id, pw, name, tel, email, addr) values (?,?,?,?,?,?)";
	public final static String MEMBER_UPDATE_YES_PW = "update member set pw = ?, name = ?, tel = ?, , email = ?, addr = ? where id = ?";
	public final static String MEMBER_UPDATE_NO_PW = "update member set name = ?, tel = ?, , email = ?, addr = ? where id = ?";
	public final static String MEMBER_DELETE = "delete from member where id = ?";
	
	
	// NOTICE
	public final static String NOTICE_LIST_ALL = "select * from notice order by noticeId desc";
	public final static String NOTICE_DETAIL = "select * from notice where noticeId = ?";
	public final static String NOTICE_UPDATE_READCNT = "update notice set readcnt = readcnt + 1 where noticeId = ?";
	public final static String NOTICE_INSERT = "insert into notice(noticeId, noticeTitle, noticeContent, writtenBy, attachment) values (?, ?, ?, ?, ?)";
	public final static String NOTICE_NOTICEID_GENERATOR = "select noticeId from notice order by noticeId desc limit 1";
	public final static String NOTICE_UPDATE_CHANGED_ATTACHMENT = "update notice set noticeTitle = ?, noticeContent = ?, attachment = ? where noticeId = ?";
	public final static String NOTICE_UPDATE_NOT_CHANGED_ATTACHMENT = "update notice set noticeTitle = ?, noticeContent = ? where noticeId = ?";
	public final static String NOTICE_DELETE = "delete from notice where noticeId = ?";
	
	
	// REVIEW
	public final static String REVIEW_LIST_ALL = "select * from review order by reviewId desc";
	public final static String REVIEW_DETAIL = "select * from review where reviewId = ?";
	public final static String REVIEW_LIST_BY_VISITID = "select * from review where visitid = ?";
	public final static String REVIEW_LIST_BY_MEMBERID = "select * from review where reviewedBy = ?";
	public final static String REVIEW_UPDATE_LIKECNT = "update review set likecnt = likecnt + 1 where reviewId = ?";
	public final static String REVIEW_INSERT = "insert into review(reviewId, reviewTitle, reviewContent, reviewedBy, visitId, point, img) values (?, ?, ?, ?, ?, ?, ?)";
	public final static String REVIEW_REVIEWID_GENERATOR = "select reviewId from review order by reviewId desc limit 1";
	public final static String REVIEW_UPDATE_CHANGED_IMG = "update review set reviewTitle = ?, reviewContent = ? img = ? where reviewId = ?";
	public final static String REVIEW_UPDATE_NOT_CHANGED_IMG = "update review set reviewTitle = ?, reviewContent = ? where reviewId = ?";
	public final static String REVIEW_DELETE = "delete from review where reviewId = ?";
	
	
	// QNA
	public final static String QNA_LIST_ALL = "select * from qna order by qIdGroup desc, qId asc";
	public final static String QNA_LIST_BY_QIDGROUP = "select * from qna where qIdGroup = ? order by qid asc";
	public final static String QNA_LIST_FORANSWER_BY_QIDGROUP = "select * from qna where qIdGroup = ? and qType = 2 order by qid asc";
	public final static String QNA_LIST_FORQUESTION_BY_QIDGROUP = "select * from qna where qIdGroup = ? and qType = 1 order by qid asc";
	public final static String QNA_LIST_DETAIL = "select * from qna where qid=?";
	public final static String QNA_QUESTION_DETAIL = "select * from qna where qid=? and qIdGroup = '1'";							//신규
	public final static String QNA_ANSWER_DETAIL = "select * from qna where qid=? and qIdGroup = '1'";								//신규
	public final static String QNA_UPDATE_READCNT = "update qna set readcnt = readcnt + 1 where qId = ?";
	public final static String QNA_INSERT_Q = "insert into qna(qid, qTitle, qContent, qType, qIdGroup, askedBy) values (?, ?, ?, ?, ?, ?)";
	public final static String QNA_INSERT_A = "insert into qna(qid, qTitle, qContent, qType, qIdGroup, askedBy) values (?, ?, ?, ?, ?, ?)";
	public final static String QNA_QID_GENERATOR = "select qid from qna order by qid desc limit 1";
	public final static String QNA_UPDATE = "update qna set qTitle = ?, qContent = ? where qid = ?";				// QNA 수정을 Q와 A로 나눌지 의견 청취 필요
	public final static String QNA_UPDATE_QUESTION = "update qna set qTitle = ?, qContent = ? where qid = ?";		// 신규
	public final static String QNA_UPDATE_ANSWER = "update qna set qTitle = ?, qContent = ? where qid=?";			// 신규
	public final static String QNA_DELETE_ALL_BY_QIDGROUP = "delete from qna where qIdGroup = ?";
	public final static String QNA_DELETE_REPLY = "delete from qna where qId = ?";
	
	
	//visit
	public final static String VISITVO = "select a.*, count(b.visitId) as pokeCnt from (select a.visitId, b.cateCode, b.cateName, a.visitTitle, a.likeCnt from visit a, category b where a.visitCateCode = b.cateCode) a left join poke b on a.visitId = b.visitId group by a.visitId";
	public final static String VISIT_LIST_BY_CATECODE = "SELECT * FROM VISIT WHERE visitCateCode=?";
	public final static String VISIT_LIST_BY_VISITID = "SELECT * FROM VISIT WHERE VISITID=?";
	public final static String ADMIN_INSERT_VISIT = "INSERT INTO VISIT VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, default)";
	public final static String ADMIN_UPDATE_VISIT = "UPDATE VISIT SET visitTitle=?, visitCateCode=?, visitAddr=?, visitMapLink=? visitImgMain=?, visitImgSub1=?, visitImgSub2=?, visitText=? where visitId=?";
	public final static String ADMIN_DELETE_VISIT = "DELETE FROM VISIT WHERE visitId=?";
	public final static String VISIT_ID_GENERATOR = "SELECT VISITID FROM VISIT ORDER BY VISITID DESC LIMIT 1";
	
	//cate
	public final static String CATE_BY_CATECODE = "SELECT * FROM CATEGORY WHERE CATECODE=?";
	public final static String CATELIST = "SELECT * FROM CATEGORY";
	public final static String CATELIST_BY_CATECODE1 = "SELECT SUBSTR(cateCode, 1, 2) AS cateCode, CATEGROUP FROM CATEGORY WHERE cateCode LIKE '%01'";
	public final static String CATELIST_BY_CATEGROUP = "SELECT * FROM CATEGORY WHERE CATEGROUP=?";
	public final static String CATELIST_BY_CATENAME = "SELECT * FROM CATEGORY WHERE CATENAME=?";
	
	//regi
	public final static String REGI_LIST_BY_MEMBER_ID = "select * from registration where registeredBy=?";
	public final static String REGI_VO_LIST_BY_MEMBER_ID = "select b.regId, b.visitId, b.registeredBy, a.visitTitle, a.visitAddr, b.regDate, b.tourDate, b.rStatus from visit a, registration b where b.registeredBy=? and a.visitId = b.visitId";
	public final static String REGI_VO_BY_REG_ID = "select b.regId, b.visitId, b.registeredBy, a.visitTitle, a.visitAddr, b.regDate, b.tourDate, b.rStatus from visit a, registration b where b.regId=? and a.visitId = b.visitId";
	public final static String INSERT_REGI = "INSERT INTO REGISTRATION VALUES(?, ?, ?, default, ?, default);";
	public final static String UPDATE_REGI = "UPDATE REGISTRATION SET tourDate=? where regId=?";
	public final static String DELETE_REGI = "DELETE FROM REGISTRATION WHERE regId=?";
	public final static String ADMIN_REGI_LIST_ALL = "select * from registration";
	public final static String ADMIN_UPDATE_RSTATUS = "UPDATE REGISTRATION SET rStatus=? where regId=?";
	public final static String REGI_ID_GENERATOR = "SELECT REGID FROM REGISTRATION ORDER BY REGID DESC LIMIT 1";
		
	//poke
	public final static String POKE_ID_GENERATOR = "SELECT POKEID FROM POKE ORDER BY POKEID DESC LIMIT 1";
	public final static String INSERT_POKE = "INSERT INTO POKE VALUES(?, ?, ?)";
	public final static String DELETE_POKE = "DELETE FROM POKE WHERE pokeId=?";
	public final static String CHECK_POKE = "SELECT * FROM POKE WHERE POKEDBY=? AND VISITID=?";
	public final static String POKEVO_LIST_BY_MEMBER_ID = "select a.pokeId, a.pokedBy, a.visitId, b.visitTitle, b.visitAddr from poke a, visit b where a.visitId = b.visitId and pokedBy=?";
	public final static String COUNT_POKE_BY_VISIT_ID = "SELECT COUNT(*) as count from poke where visitId=? group by visitId";	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}