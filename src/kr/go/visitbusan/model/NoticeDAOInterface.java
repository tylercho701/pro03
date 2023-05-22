package kr.go.visitbusan.model;

import java.util.ArrayList;

public interface NoticeDAOInterface {
	public ArrayList<NOTICEDTOF> getNoticeList();
	public NoticeDTOF getNotice (int no);
	public int addNotice(NoticeDTOF dto);
	public int delNotice(int no);
	public int modiftyNotice(NoticeDTOF dto);
}