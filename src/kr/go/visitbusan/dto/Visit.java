package kr.go.visitbusan.dto;

public class Visit {
	private String visitId;
	private String visitTitle;
	private String visitCateCode;
	private String visitAddr;
	private String visitImgMain;
	private String visitImgSub1;
	private String visitImgSub2;
	private String likeCnt;
	
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public String getVisitTitle() {
		return visitTitle;
	}
	public void setVisitTitle(String visitTitle) {
		this.visitTitle = visitTitle;
	}
	public String getVisitCateCode() {
		return visitCateCode;
	}
	public void setVisitCateCode(String visitCateCode) {
		this.visitCateCode = visitCateCode;
	}
	public String getVisitAddr() {
		return visitAddr;
	}
	public void setVisitAddr(String visitAddr) {
		this.visitAddr = visitAddr;
	}
	public String getVisitImgMain() {
		return visitImgMain;
	}
	public void setVisitImgMain(String visitImgMain) {
		this.visitImgMain = visitImgMain;
	}
	public String getVisitImgSub1() {
		return visitImgSub1;
	}
	public void setVisitImgSub1(String visitImgSub1) {
		this.visitImgSub1 = visitImgSub1;
	}
	public String getVisitImgSub2() {
		return visitImgSub2;
	}
	public void setVisitImgSub2(String visitImgSub2) {
		this.visitImgSub2 = visitImgSub2;
	}
	public String getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(String likeCnt) {
		this.likeCnt = likeCnt;
	}
}
