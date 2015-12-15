package com.hanains.mysite.vo;

public class BoardVo {

	private long no;
	private String title;
	private String memberNo;
	private String name;
	private String content;
	private String regDate;
	private String view_cnt;
	
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
	
	public String getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(String view_cnt) {
		this.view_cnt = view_cnt;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", memberNo=" + memberNo + ", name=" + name + ", content="
				+ content + ", regDate=" + regDate + ", view_cnt=" + view_cnt + "]";
	}
}
