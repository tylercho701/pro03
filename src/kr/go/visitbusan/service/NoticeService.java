package kr.go.visitbusan.service;

import java.util.ArrayList;

import kr.go.visitbusan.dto.Notice;
import kr.go.visitbusan.model.NoticeDAOInterface;
import kr.go.visitbusan.model.NoticeDAO;


public class NoticeService {

	NoticeDAOInterface dao = new NoticeDAO();
	
	public ArrayList<Notice> noticeListAll(){			//공지사항 목록
		ArrayList<Notice> notiList = dao.noticeListAll();
		return notiList;
	}
	public Notice noticeDetail(String noticeId) {		//공지사항 상세 글보기
		Notice notice = dao.noticeDetail(noticeId);
		return notice;
	}
	public void noticeUpdateReadCnt(String noticeId){
		dao.noticeUpdateReadCnt(noticeId);
	}
	public int noticeInsert(Notice dto) {				//공지사항 추가
		int cnt = dao.noticeInsert(dto);
		return cnt;
	}
	public String noticeIdGererator(){
		String NoticeId = dao.noticeIdGenerator();
		return NoticeId;
	}
	public Notice noticeUpdate(String noticeId){
		Notice noti = dao.noticeUpdate(noticeId);
		return noti;
	}
	public int noticeUpdatePro(Notice dto) {			//공지사항 수정
		int cnt = dao.noticeUpdatePro(dto);
		return cnt;
	}
	public int noticeDelete(String noticeId) {			//공지사항 삭제
		int cnt = dao.noticeDelete(noticeId);
		return cnt;
	}
}