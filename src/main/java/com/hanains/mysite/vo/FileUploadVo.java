package com.hanains.mysite.vo;

public class FileUploadVo {

	private Long no;
	private Long boardNo;
	private String originalFileName;
	private String storedFileName;
	private Long fileSize;
	private String regDate;
	private String regId;
	private String delCheck;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(Long boardNo) {
		this.boardNo = boardNo;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getDelCheck() {
		return delCheck;
	}
	public void setDelCheck(String delCheck) {
		this.delCheck = delCheck;
	}
	
	@Override
	public String toString() {
		return "FileUploadVo [no=" + no + ", boardNo=" + boardNo + ", originalFileName=" + originalFileName
				+ ", storedFileName=" + storedFileName + ", fileSize=" + fileSize + ", regDate=" + regDate + ", regId="
				+ regId + ", delCheck=" + delCheck + "]";
	}
}
