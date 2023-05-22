package kr.go.visitbusan.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.go.visitbusan.util.MySQL8;

import org.junit.Test;

public class MySQLTest {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	String sql = "";
	
	@Test
	public void test1() {
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.SELECT_SAMPLE_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("item1"));
				System.out.println(rs.getInt("item2"));
				System.out.println(rs.getString("item3"));
				System.out.println("*****************************************");
			}
		} catch(Exception e){
			System.out.println("데이터베이스 연동 실패");
		}
	}
}
