package kr.go.jeju.service;

import java.util.ArrayList;

import kr.go.jeju.dto.MemberDTO;
import kr.go.jeju.model.MemberDAO;
import kr.go.jeju.model.MemberDAOMysql;

public class MemberService {
	MemberDAO dao = new MemberDAOMysql();
	
	public int idCheckPro(String id){	//아이디 중복 체크
		int cnt = dao.idCheckPro(id);
		return cnt;
	}
	public int addMember(MemberDTO member){	//회원 가입
		int cnt = dao.addMember(member);
		return cnt;
	}
	public int MemberLogin(String id, String pw){	//로그인
		int cnt = dao.MemberLogin(id, pw);
		return cnt;
	}
	public MemberDTO MemberInfo(String id){	//마이페이지
		MemberDTO dto = dao.MemberInfo(id);
		return dto;
	}
	public int updateMember(MemberDTO member){	//회원정보 수정
		int cnt = dao.updateMember(member);
		return cnt;
	}
	public ArrayList<MemberDTO> getMemberList(){	//회원 목록
		ArrayList<MemberDTO> memList = dao.getMemberList();
		return memList;
	}
}
