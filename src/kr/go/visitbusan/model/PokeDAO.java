package kr.go.visitbusan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.visitbusan.dto.Poke;
import kr.go.visitbusan.util.MySQL8;

public class PokeDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int InsertPoke(Poke poke){
		int i = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.INSERT_POKE);
			pstmt.setString(1, poke.getPokeId());
			pstmt.setString(2, poke.getPokedBy());
			pstmt.setString(3, poke.getVisitId());
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt);
		}
		return i;
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
	
	public ArrayList<Poke> PokeListByMemberId(String pokedBy){
		ArrayList<Poke> pokeList = new ArrayList<Poke>();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.POKE_LIST_BY_MEMBER_ID);
			pstmt.setString(1, pokedBy);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Poke poke = new Poke();
				poke.setPokeId(rs.getString("pokeId"));
				poke.setPokedBy(rs.getString("pokedBy"));
				poke.setVisitId(rs.getString("visitId"));
				pokeList.add(poke);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}
		return pokeList;
	}
	
	public int CountPokeListByVisitId(){
		int i = 0;
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.COUNT_POKE_LIST_BY_VISIT_ID);
			i = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt);
		}
		return i;
	}
}
