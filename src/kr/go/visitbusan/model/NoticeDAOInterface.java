package kr.go.visitbusan.model;

public interface NoticeDAOInterface {
	public ArrayList<NOTICEDTO> getNoticeList();
	public NoticeDTO getNotice (int no);
	public int addNotice(NoticeDTO dto);
	public int delNotice(int no);
	public int modiftyNotice(NoticeDTO dto);
}