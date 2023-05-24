package kr.go.visitbusan.dto;

public class QnA {
	private String qId;
	private String qTitle;
	private String qContent;
	private int qType;
	private String qIdGroup;
	private String askedAt;
	private String askedBy;
	private int readCnt;
	
	public final String getqId() {
		return qId;
	}
	public final void setqId(String qId) {
		this.qId = qId;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public final int getqType() {
		return qType;
	}
	public final void setqType(int qType) {
		this.qType = qType;
	}
	public String getqIdGroup() {
		return qIdGroup;
	}
	public void setqIdGroup(String qIdGroup) {
		this.qIdGroup = qIdGroup;
	}
	public String getAskedAt() {
		return askedAt;
	}
	public void setAskedAt(String askedAt) {
		this.askedAt = askedAt;
	}
	public String getAskedBy() {
		return askedBy;
	}
	public void setAskedBy(String askedBy) {
		this.askedBy = askedBy;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	
}
