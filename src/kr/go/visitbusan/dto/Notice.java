package kr.go.visitbusan.dto;

import java.util.Date;

public class Notice {
	private String noticeId;
	private String noticeTitle;
	private String noticeContent;
	private Date writtenAt;
	private String writtenBy;
	private String attachment;
	private int readCnt;
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getWrittenAt() {
		return writtenAt;
	}
	public void setWrittenAt(Date writtenAt) {
		this.writtenAt = writtenAt;
	}
	public String getWrittenBy() {
		return writtenBy;
	}
	public void setWrittenBy(String writtenBy) {
		this.writtenBy = writtenBy;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	
}
