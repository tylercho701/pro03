package kr.go.visitbusan.model;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.go.visitbusan.dto.Member;
import kr.go.visitbusan.util.MySQL8;

import com.crypto.util.AES256;

public class MemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	String key = "%03x";
	String qpw;
	
	// 로그인 시 ID 확인, logCnt +1
	public int memberLogin(String id, String pw) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.MEMBER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				if(pw.equals(qpw)){
					cnt = 1;
				} else {
					cnt = 0;
				} 
			} else {
				cnt = 9;
			}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				MySQL8.close(conn, pstmt, rs);
			}
		memberUpdateLogCnt(id);
		return cnt;
	}
	
	// logCnt+1
	public void memberUpdateLogCnt(String id){
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.MEMBER_UPDATE_LOGCNT);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt);
		}
	}
	
	// 내정보
	public Member memberMyInfo(String id) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		Member mem = new Member();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.MEMBER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				mem.setId(rs.getString("id"));
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				int k = qpw.length();				//암호 글자수 세기
				String vpw = qpw.substring(0, 3);	//3글자만 암호를 보여주기
				String hpw = "";
				for(int i=0;i<k-3;i++){				//나머지는 *로 넣기
					hpw+="*";
				}
				mem.setPw(vpw+hpw);
				mem.setName(rs.getString("name"));
				mem.setTel(rs.getString("tel"));
				mem.setEmail(rs.getString("email"));
				mem.setAddr(rs.getString("addr"));
				mem.setLogCnt(rs.getInt("logcnt"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}
		return mem;
	}
	
	// 회원가입 (조인)
	public int memberInsert(Member mem){
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.MEMBER_INSERT);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPw());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getTel());
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getAddr());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt);
		}
		return cnt;
	}
	
	// 사용자 정보 변경 1 : 비밀번호 변경 할 경우
	public int memberUpdateYesPw(Member mem){
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.MEMBER_UPDATE_YES_PW);
			pstmt.setString(1, mem.getPw());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getTel());
			pstmt.setString(4, mem.getEmail());
			pstmt.setString(5, mem.getAddr());
			pstmt.setString(6, mem.getId());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt);
		}
		return cnt;
	}
	
	// 사용자 정보 변경 2 : 비밀번호 변경 안 할 경우
	public int memberUpdateNoPw(Member mem){
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.MEMBER_UPDATE_NO_PW);
			pstmt.setString(1, mem.getName());
			pstmt.setString(2, mem.getTel());
			pstmt.setString(3, mem.getEmail());
			pstmt.setString(4, mem.getAddr());
			pstmt.setString(5, mem.getId());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt);
		}
		return cnt;
	}
	
	
	// 사용자 삭제 (회원탈퇴)
	public int memberDelete(String id){
		int cnt = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.MEMBER_DELETE);
			pstmt.setString(1, id);
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt);
		}
		return cnt;
	}
	
}
