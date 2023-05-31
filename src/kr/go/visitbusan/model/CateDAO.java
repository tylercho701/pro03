package kr.go.visitbusan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.go.visitbusan.dto.Category;
import kr.go.visitbusan.util.MySQL8;

public class CateDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public Category CatebyCateCode(String cateCode){
		Category cate = new Category();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.CATE_BY_CATECODE);
			pstmt.setString(1, cateCode);
			rs = pstmt.executeQuery();
			if (rs.next()){
				cate.setCateCode(rs.getString("cateCode"));
				cate.setCateGroup(rs.getString("cateGroup"));
				cate.setCateName(rs.getString("cateName"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}
		return cate;
	}
	
	public ArrayList<Category> CateListbyCateCode1(){
		ArrayList<Category> cateList = new ArrayList<Category>();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.CATELIST_BY_CATECODE1);
			rs = pstmt.executeQuery();
			while (rs.next()){
				Category cate = new Category();
				cate.setCateCode(rs.getString("cateCode"));
				cate.setCateGroup(rs.getString("cateGroup"));
				cateList.add(cate);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}
		return cateList;
	}
	
	public ArrayList<Category> CateListByCateGroup(String cateGroup){
		ArrayList<Category> cateList = new ArrayList<Category>();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.CATELIST_BY_CATEGROUP);
			pstmt.setString(1, cateGroup);
			rs = pstmt.executeQuery();
			while (rs.next()){
				Category cate = new Category();
				cate.setCateCode(rs.getString("cateCode"));
				cate.setCateGroup(rs.getString("cateGroup"));
				cate.setCateName(rs.getString("cateName"));
				cateList.add(cate);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}
		return cateList;
	}
	
	public ArrayList<Category> CateListByCateName(){
		ArrayList<Category> cateList = new ArrayList<Category>();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.CATELIST_BY_CATENAME);
			rs = pstmt.executeQuery();
			while (rs.next()){
				Category cate = new Category();
				cate.setCateCode(rs.getString("cateCode"));
				cate.setCateGroup(rs.getString("cateGroup"));
				cate.setCateName(rs.getString("cateName"));
				cateList.add(cate);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MySQL8.close(conn, pstmt, rs);
		}
		return cateList;
	}
	
	public ArrayList<Category> menuLoad(){
		ArrayList<Category> cateList = new ArrayList<Category>();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.CATELIST);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Category cate = new Category();
				cate.setCateCode(rs.getString("cateCode"));
				cate.setCateGroup(rs.getString("cateGroup"));
				cate.setCateName(rs.getString("cateName"));
				cateList.add(cate);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return cateList;
	}
}
