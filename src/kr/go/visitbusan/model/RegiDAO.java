package kr.go.visitbusan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.visitbusan.dto.Registration;
import kr.go.visitbusan.util.MySQL8;

public class RegiDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<Registration> RegiListByMemberId(String memberId){
		ArrayList<Registration> regiList = new ArrayList<Registration>();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.REGI_LIST_BY_MEMBER_ID);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Registration regi = new Registration();
				regi.setRegId(rs.getString("regId"));
				regi.setRegisteredBy(rs.getString("registeredBy"));
				regi.setVisitId(rs.getString("visitId"));
				regi.setRegDate(rs.getString("regDate"));
				regi.setrStatus(rs.getString("rStatus"));
				regiList.add(regi);
			}
		} catch (ClassNotFoundException | SQLException e) {
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}	
		return regiList;
	}
	
	public int InsertRegi(Registration regi){
		int i = 0;
		int rId = 0;
		String regId = "";
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.REGI_ID_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				rId = Integer.parseInt(rs.getString("regId"));
			}
			rId += 1;
			regId = rId+"";
			
			pstmt = conn.prepareStatement(MySQL8.INSERT_REGI);
			pstmt.setString(1, regId);
			pstmt.setString(2, regi.getRegisteredBy());
			pstmt.setString(3, regi.getVisitId());
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}	
		return i;
	}
	
	public int UpdateRegi(Registration regi){
		int i = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.UPDATE_REGI);
			pstmt.setString(1, regi.getVisitId());
			pstmt.setString(2, regi.getRegDate());
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int DeleteRegi(String regId){
		int i = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.DELETE_REGI);
			pstmt.setString(1, regId);
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public ArrayList<Registration> AdminRegiListAll(){
		ArrayList<Registration> regiList = new ArrayList<Registration>();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.ADMIN_REGI_LIST_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Registration regi = new Registration();
				regi.setRegId(rs.getString("regId"));
				regi.setRegisteredBy(rs.getString("registeredBy"));
				regi.setVisitId(rs.getString("visitId"));
				regi.setRegDate(rs.getString("regDate"));
				regi.setrStatus(rs.getString("rStatus"));
				regiList.add(regi);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return regiList;
	}
	
	public int AdminUpdateRstatus(String rStatus, String regId){
		int i = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.ADMIN_UPDATE_RSTATUS);
			pstmt.setString(1, rStatus);
			pstmt.setString(2, regId);
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}