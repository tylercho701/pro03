package kr.go.visitbusan.model;

import java.util.ArrayList;

import kr.go.visitbusan.dto.Member;

public interface MemberDAOInterface {
	public int memberLogin(String id, String pw);
	public void memberUpdateLogCnt(String id);
	public int idCheck(String id);
	public ArrayList<Member> memberList();
	public Member memberMyInfo(String id);
	public int memberInsert(Member mem);
	public int memberUpdateYesPw(Member mem);
	public int memberUpdateNoPw(Member mem);
	public int memberDelete(String id);
}
