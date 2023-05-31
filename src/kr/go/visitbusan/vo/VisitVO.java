package kr.go.visitbusan.vo;

public class VisitVO {
	private String visitId;
	private String cateCode;
	private String cateName;
	private String visitTitle;
	private int likeCnt;
	private int pokeCnt;
	
	public String getVisitId() {
		return visitId;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getVisitTitle() {
		return visitTitle;
	}
	public void setVisitTitle(String visitTitle) {
		this.visitTitle = visitTitle;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public int getPokeCnt() {
		return pokeCnt;
	}
	public void setPokeCnt(int pokeCnt) {
		this.pokeCnt = pokeCnt;
	}
	
	
}
