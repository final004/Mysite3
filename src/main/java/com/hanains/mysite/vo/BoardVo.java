package com.hanains.mysite.vo;

import org.springframework.web.multipart.MultipartFile;

public class BoardVo {

	private long no;
	private String title;
	private String memberNo;
	private String name;
	private String content;
	private String regDate;
	private String viewCnt;
	private MultipartFile boardFile;
	private String fileName;
	private int reRef;
	private int reLev;
	private int reSeq;
	
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
	public MultipartFile getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(MultipartFile boardFile) {
		this.boardFile = boardFile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getReRef() {
		return reRef;
	}
	public void setReRef(int reRef) {
		this.reRef = reRef;
	}
	public int getReLev() {
		return reLev;
	}
	public void setReLev(int reLev) {
		this.reLev = reLev;
	}
	public int getReSeq() {
		return reSeq;
	}
	public void setReSeq(int reSeq) {
		this.reSeq = reSeq;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", memberNo=" + memberNo + ", name=" + name + ", content="
				+ content + ", regDate=" + regDate + ", viewCnt=" + viewCnt + ", boardFile=" + boardFile + ", fileName="
				+ fileName + ", reRef=" + reRef + ", reLev=" + reLev + ", reSeq=" + reSeq + "]";
	}

}
