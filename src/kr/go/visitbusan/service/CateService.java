package kr.go.visitbusan.service;

import java.util.ArrayList;

import kr.go.visitbusan.dto.Category;
import kr.go.visitbusan.model.CateDAO;

public class CateService {
	CateDAO cdao = new CateDAO();
	
	// CATECODE 0101 ~ 0304
	public Category CatebyCateCode(String cateCode){
		Category cate = cdao.CatebyCateCode(cateCode);
		return cate;
	}
	
	// CATECODE 01 02 03
	public ArrayList<Category> CateListbyCateCode1(){
		ArrayList<Category> cateList = cdao.CateListbyCateCode1();
		return cateList;
	}
	
	public ArrayList<Category> CateListByCateGroup(String cateGroup){
		ArrayList<Category> cateList = cdao.CateListByCateGroup(cateGroup);
		return cateList;
	}
	
	public ArrayList<Category> menuLoad(){
		ArrayList<Category> cateList = cdao.menuLoad();
		return cateList;
	}
}
