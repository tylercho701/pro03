package kr.go.visitbusan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.visitbusan.dto.Visit;
import kr.go.visitbusan.util.MySQL8;
import kr.go.visitbusan.vo.VisitVO;

public class VisitDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public ArrayList<Visit> visitListByCateCode(String cateCode){
		ArrayList<Visit> visitList = new ArrayList<Visit>();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.VISIT_LIST_BY_CATECODE);
			pstmt.setString(1, cateCode);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Visit visit = new Visit();
				visit.setVisitId(rs.getString("visitId"));
				visit.setVisitTitle(rs.getString("visitTitle"));
				visit.setVisitCateCode(cateCode);
				visit.setVisitAddr(rs.getString("visitAddr"));
				visit.setVisitMapLink(rs.getString("visitMapLink"));
				visit.setVisitImgMain(rs.getString("visitImgMain"));
				visit.setVisitImgSub1(rs.getString("visitImgSub1"));
				visit.setVisitImgSub2(rs.getString("visitImgSub2"));
				visit.setLikeCnt(rs.getInt("likeCnt"));
				visitList.add(visit);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}
		return visitList;
	}
	
	// visitDetail
	public Visit visitByVisitId(String visitId){
		Visit visit = new Visit();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.VISIT_LIST_BY_VISITID);
			pstmt.setString(1, visitId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				visit.setVisitId(visitId);
				visit.setVisitTitle(rs.getString("visitTitle"));
				visit.setVisitCateCode(rs.getString("visitCateCode"));
				visit.setVisitAddr(rs.getString("visitAddr"));
				visit.setVisitMapLink(rs.getString("visitMapLink"));
				visit.setVisitImgMain(rs.getString("visitImgMain"));
				visit.setVisitImgSub1(rs.getString("visitImgSub1"));
				visit.setVisitImgSub2(rs.getString("visitImgSub2"));
				visit.setVisitText(rs.getString("visitText"));
				visit.setLikeCnt(rs.getInt("likeCnt"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return visit;
	}
	
	public int insertVisit(Visit visit){
		int i = 0;
		int vId = 0;
		String visitId = "";
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.VISIT_ID_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				vId = Integer.parseInt(rs.getString("visitId"));
			}
			vId += 1;
			visitId = vId+"";
			pstmt = conn.prepareStatement(MySQL8.ADMIN_INSERT_VISIT);
			pstmt.setString(1, visitId);
			pstmt.setString(2, visit.getVisitTitle());
			pstmt.setString(3, visit.getVisitCateCode());
			pstmt.setString(4, visit.getVisitAddr());
			pstmt.setString(5, visit.getVisitMapLink());
			pstmt.setString(6, visit.getVisitImgMain());
			pstmt.setString(7, visit.getVisitImgSub1());
			pstmt.setString(8, visit.getVisitImgSub2());
			pstmt.setString(9, visit.getVisitText());
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt);
		}
		return i;
	}
	
	public int updateVisit(Visit visit){
		int i = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.ADMIN_UPDATE_VISIT);
			pstmt.setString(1, visit.getVisitTitle());
			pstmt.setString(2, visit.getVisitCateCode());
			pstmt.setString(3, visit.getVisitAddr());
			pstmt.setString(4, visit.getVisitMapLink());
			pstmt.setString(5, visit.getVisitImgMain());
			pstmt.setString(6, visit.getVisitImgSub1());
			pstmt.setString(7, visit.getVisitImgSub2());
			pstmt.setString(8, visit.getVisitId());
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt);
		}
		return i;
	}
	
	public int deleteVisit(String visitId){
		int i = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.ADMIN_DELETE_VISIT);
			pstmt.setString(1, visitId);
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt);
		}
		return i;
	}
	
	public ArrayList<VisitVO> getVisitVO(){
		ArrayList<VisitVO> visitVOList = new ArrayList<VisitVO>();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.VISITVO);
			rs = pstmt.executeQuery();
			while(rs.next()){
				VisitVO visitVO = new VisitVO();
				visitVO.setVisitId(rs.getString("visitId"));
				visitVO.setCateCode(rs.getString("cateCode"));
				visitVO.setCateName(rs.getString("cateName"));
				visitVO.setVisitTitle(rs.getString("visitTitle"));
				visitVO.setLikeCnt(rs.getInt("likeCnt"));
				visitVO.setPokeCnt(rs.getInt("pokeCnt"));
				visitVOList.add(visitVO);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return visitVOList;
	}
}
