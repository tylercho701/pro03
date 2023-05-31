package kr.go.visitbusan.service;

import java.util.ArrayList;

import kr.go.visitbusan.dto.Registration;
import kr.go.visitbusan.model.RegiDAO;
import kr.go.visitbusan.vo.RegistrationVO;

public class RegiService {
	RegiDAO rdao = new RegiDAO();
	
	public ArrayList<Registration> RegiListByMemberId(String memberId){
		ArrayList<Registration> regiList = rdao.RegiListByMemberId(memberId);
		return regiList;
	}
	
	public ArrayList<RegistrationVO> RegiVOListByMemberId(String memberId){
		ArrayList<RegistrationVO> regiVOList = rdao.RegiVOListByMemberId(memberId);
		return regiVOList;
	}
	
	public RegistrationVO RegiVOBYRegId(String regId){
		RegistrationVO regi = rdao.RegiVOBYRegId(regId);
		return regi;
	}
	
	public int InsertRegi(Registration regi){
		int i = rdao.InsertRegi(regi);
		return i;
	}
	
	public int UpdateRegi(Registration regi){
		int i = rdao.UpdateRegi(regi);
		return i;
	}
	
	public int DeleteRegi(String regId){
		int i = rdao.DeleteRegi(regId);
		return i;
	}
	
	public ArrayList<Registration> AdminRegiListAll(){
		ArrayList<Registration> regiList = rdao.AdminRegiListAll();
		return regiList;
	}
	
	public int AdminUpdateRstatus(String rStatus, String regId){
		int i = rdao.AdminUpdateRstatus(rStatus, regId);
		return i;
	}
}
