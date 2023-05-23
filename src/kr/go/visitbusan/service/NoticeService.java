package kr.go.visitbusan.service;

import java.util.ArrayList;

import kr.go.visitbusan.dto.Notice;
import kr.go.visitbusan.model.NoticeDAOInterface;
import kr.go.visitbusan.model.NoticeDAOMySQL;


public class NoticeService {

	NoticeDAOInterface dao = new NoticeDAOMySQL();
	
	public ArrayList<Notice> noticeListAll(){			//공지사항 목록
		ArrayList<Notice> notiList = dao.noticeListAll();
		return notiList;
	}
	public Notice noticeDetail(String noticeId) {		//공지사항 상세 글보기
		Notice notice = dao.noticeDetail(noticeId);
		return notice;
	}
	public int noticeInsert(Notice dto) {				//공지사항 추가
		int cnt = dao.noticeInsert(dto);
		return cnt;
	}
	public int noticeDelete(String noticeId) {			//공지사항 삭제
		int cnt = dao.noticeDelete(noticeId);
		return cnt;
	}
	public int noticeUpdatePro(Notice dto) {			//공지사항 수정
		int cnt = dao.noticeUpdatePro(dto);
		return cnt;
	}
}