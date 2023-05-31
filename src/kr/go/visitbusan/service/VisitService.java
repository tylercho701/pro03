package kr.go.visitbusan.service;

import java.util.ArrayList;

import kr.go.visitbusan.dto.Visit;
import kr.go.visitbusan.model.VisitDAO;
import kr.go.visitbusan.vo.VisitVO;

public class VisitService {
	VisitDAO vdao = new VisitDAO();
	
	// 특정 cateCode의 visit 목록
	public ArrayList<Visit> visitListByCateCode(String cateCode){
		ArrayList<Visit> visitList = vdao.visitListByCateCode(cateCode);
		return visitList;
	}
	
	// visitDetail
	public Visit visitByVisitId(String visitId){
		Visit visit = vdao.visitByVisitId(visitId);
		return visit;
	}
	
	//
	public int insertVisit(Visit visit){
		int i = vdao.insertVisit(visit);
		return i;
	}
	
	//
	public int updateVisit(Visit visit){
		int i = vdao.updateVisit(visit);
		return i;
	}
	
	//
	public int deleteVisit(String visitId){
		int i = vdao.deleteVisit(visitId);
		return i;
	}
	
	public ArrayList<VisitVO> getVisitVO(){
		ArrayList<VisitVO> visitVOList = vdao.getVisitVO();
		return visitVOList;
	}
}
