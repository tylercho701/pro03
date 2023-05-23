package kr.go.visitbusan.service;

import java.util.ArrayList;

import kr.go.visitbusan.dto.Member;
import kr.go.visitbusan.model.MemberDAO;
import kr.go.visitbusan.model.MemberDAOInterface;

public class MemberService {
	MemberDAOInterface dao = new MemberDAO();
	
	public int memberLogin(String id, String pw){
		int cnt = dao.memberLogin(id, pw);
		return cnt;
	}
	public void memberUpdateLogCnt(String id){
		dao.memberUpdateLogCnt(id);
	}
	public int idCheck(String id){
		int cnt = dao.idCheck(id);
		return cnt;
	}
	public ArrayList<Member> memberList(){
		ArrayList<Member> memList = dao.memberList();
		return memList;
	}
	public Member memberMyInfo(String id){
		Member mem = dao.memberMyInfo(id);
		return mem;
	}
	public int memberInsert(Member mem){
		int cnt = dao.memberInsert(mem);
		return cnt;
	}
	public int memberUpdateYesPw(Member mem){
		int cnt = dao.memberUpdateYesPw(mem);
		return cnt;
	}
	public int memberUpdateNoPw(Member mem){
		int cnt = dao.memberUpdateNoPw(mem);
		return cnt;
	}
	public int memberDelete(String id){
		int cnt = dao.memberDelete(id);
		return cnt;
	}
}
