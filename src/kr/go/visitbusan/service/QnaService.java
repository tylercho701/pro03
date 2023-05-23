package kr.go.jeju.service;

import java.util.ArrayList;

import kr.go.jeju.dto.QnaDTO;
import kr.go.jeju.model.QnaDAO;
import kr.go.jeju.model.QnaDAOMysql;

public class QnaService {
	QnaDAO dao = new QnaDAOMysql();
	
	public ArrayList<QnaDTO> getQnaList(){	//질문 및 답변 목록
		ArrayList<QnaDTO> qnaList = dao.getQnaList();
		return qnaList;
	}
	public QnaDTO getQna(int no){	//해당 글 자세히 보기
		QnaDTO dto = dao.getQna(no);
		return dto;
	}
	public int addQna(QnaDTO dto){	//질문 추가하기
		int cnt = dao.addQna(dto);
		return cnt;
	}
	public int addReply(QnaDTO dto){	//답변 추가하기
		int cnt = dao.addReply(dto);
		return cnt;		
	}
	public int delQna(int no, int parno){	//질문 및 답변 삭제하기
		int cnt = dao.delQna(no, parno);
		return cnt;
	}
	public int modifyQna(QnaDTO dto){	//질문 및 답변 수정하기
		int cnt = dao.modifyQna(dto);
		return cnt;
	}
}
