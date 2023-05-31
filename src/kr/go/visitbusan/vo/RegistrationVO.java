package kr.go.visitbusan.vo;

public class RegistrationVO {
	private String regId;
	private String visitId;
	private String registeredBy;
	private String visitTitle;
	private String visitAddr;
	private String regDate;
	private String tourDate;
	private String rStatus;
	
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public String getRegisteredBy() {
		return registeredBy;
	}
	public void setRegisteredBy(String registeredBy) {
		this.registeredBy = registeredBy;
	}
	public String getVisitTitle() {
		return visitTitle;
	}
	public void setVisitTitle(String visitTitle) {
		this.visitTitle = visitTitle;
	}
	public String getVisitAddr() {
		return visitAddr;
	}
	public void setVisitAddr(String visitAddr) {
		this.visitAddr = visitAddr;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getTourDate() {
		return tourDate;
	}
	public void setTourDate(String tourDate) {
		this.tourDate = tourDate;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
}
