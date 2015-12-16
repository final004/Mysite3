package com.hanains.mysite.vo;

public class BoardVo {

	private long no;
	private String title;
	private String memberNo;
	private String name;
	private String content;
	private String regDate;
	private String viewCnt;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public String getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(String viewCnt) {
		this.viewCnt = viewCnt;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", memberNo=" + memberNo + ", name=" + name + ", content="
				+ content + ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}
}
