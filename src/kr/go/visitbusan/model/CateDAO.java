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
	
	public ArrayList<Category> CateListByCateCode(){
		ArrayList<Category> cateList = new ArrayList<Category>();
		try {
			conn = MySQL8.getConnection();
			pstmt = conn.prepareStatement(MySQL8.CATELIST_BY_CATECODE);
			rs = pstmt.executeQuery();
			while (rs.next()){
				Category cate = new Category();
				cate.setCateCode(rs.getString("catecode"));
				cate.setCateGroup(rs.getString("categroup"));
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
}
