package kr.go.jeju.service;

import java.util.ArrayList;

import kr.go.jeju.dto.ImpressDTO;
import kr.go.jeju.model.ImpressDAO;
import kr.go.jeju.model.ImpressDAOMysql;

public class ImpressService {
	ImpressDAO dao = new ImpressDAOMysql();
	
	public ArrayList<ImpressDTO> getImpressList() { //이용후기 목록
		ArrayList<ImpressDTO> impList = dao.getImpressList();
		return impList;
	}
	public ImpressDTO getImpress(int no) { //이용후기 상세보기
		ImpressDTO dto = dao.getImpress(no);
		return dto; 
	}
	public void addImpress(ImpressDTO dto) { //이용후기 추가
		dao.addImpress(dto);
	}
	public int delImpress(int no) { //이용후기 삭제
		int cnt = dao.delImpress(no);
		return cnt;
	}
	public int modifyImpress(ImpressDTO dto){  //이용후기 수정
		int cnt = dao.modifyImpress(dto);
		return cnt;
	}
}
