package kr.go.visitbusan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.visitbusan.dto.Poke;
import kr.go.visitbusan.util.MySQL8;
import kr.go.visitbusan.vo.PokeVO;

public class PokeDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public Poke CheckPoke(Poke poke){
		Poke nPoke = new Poke();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.CHECK_POKE);
			pstmt.setString(1, poke.getPokedBy());
			pstmt.setString(2, poke.getVisitId());
			rs = pstmt.executeQuery();
			if(rs.next()){
				nPoke.setPokeId(rs.getString("pokeId"));
				nPoke.setPokedBy(rs.getString("pokedBy"));
				nPoke.setVisitId(rs.getString("visitId"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return nPoke;
	}
	
	public String InsertPoke(Poke poke){
		int pId = 0;
		String pokeId = "";
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.POKE_ID_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				pId = Integer.parseInt(rs.getString("pokeId"));
			}
			pId += 1;
			pokeId = pId+"";
		
			pstmt = conn.prepareStatement(MySQL8.INSERT_POKE);
			pstmt.setString(1, pokeId);
			pstmt.setString(2, poke.getPokedBy());
			pstmt.setString(3, poke.getVisitId());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt);
		}
		return pokeId;
	}
	
	public int DeletePoke(String pokeId){
		int i = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.DELETE_POKE);
			pstmt.setString(1, pokeId);
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt);
		}
		return i;
	}
	
	public ArrayList<PokeVO> PokeVOListByMemberId(String pokedBy){
		ArrayList<PokeVO> pokeVOList = new ArrayList<PokeVO>();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.POKEVO_LIST_BY_MEMBER_ID);
			pstmt.setString(1, pokedBy);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PokeVO poke = new PokeVO();
				poke.setPokeId(rs.getString("pokeId"));
				poke.setPokedBy(pokedBy);
				poke.setVisitId(rs.getString("visitId"));
				poke.setVisitTitle(rs.getString("visitTitle"));
				poke.setVisitAddr(rs.getString("visitAddr"));
				pokeVOList.add(poke);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}
		return pokeVOList;
	}
	
	public int CountPokeListByVisitId(String visitId){
		int i = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.COUNT_POKE_BY_VISIT_ID);
			pstmt.setString(1, visitId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				i = Integer.parseInt(rs.getString("count"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}
		return i;
	}
}
