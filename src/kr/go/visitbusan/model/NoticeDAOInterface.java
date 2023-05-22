package kr.go.visitbusan.model;

import java.util.ArrayList;

import kr.go.visitbusan.dto.Notice;

public interface NoticeDAOInterface {
	public ArrayList<Notice> noticeListAll();
	public Notice noticeDetail(String noticeId);
	public void noticeUpdateReadCnt(String noticeId);
	public int noticeInsert(Notice noti);
	public String noticeIdGenerator();
	public Notice noticeUpdate(String noticeId);
	public int noticeUpdatePro(Notice noti);
	public int noticeDelete(String noticeId);
	
}