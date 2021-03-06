package com.kopo.memo;

public class Memo {
	public int idx;
	public String title;
	public String memo;
	public String created;
	public String updated;
	
//	public final String DB_FILE_NAME = "c:\\tomcat\\memo4.db";
	public final String DB_FILE_NAME = "/Users/saebyul/SqliteDB/memo.db";
	public final String TABLE_NAME = "memo";
	
	public Memo() {
	}
	
	public Memo(String title, String memo) {
		this.title = title;
		this.memo = memo;
	}
	
	public Memo(int idx, String title, String memo) {
		this.idx = idx;
		this.title = title;
		this.memo = memo;
	}
	
	public String toHtmlString() {
		StringBuffer htmlString = new StringBuffer();
		htmlString.append("<tr>");
		htmlString.append("<td>" + this.idx + "</td>");
		htmlString.append("<td>" + this.title + "</td>");
		htmlString.append("<td>" + this.memo + "</td>");
		htmlString.append("<td>" + this.created + "</td>");
		htmlString.append("<td>" + this.updated + "</td>");
		htmlString.append("<td>" + "<a href='u1?idx=" + this.idx + "'>수정하기</a>" + "</td>");
		htmlString.append("<td>" + "<a href='delete?idx=" + this.idx + "'>삭제하기</a>" + "</td>");
		htmlString.append("</tr>");
		return htmlString.toString();
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getMemo() {
		return this.memo;
	}
	
	public int getIdx() {
		return this.idx;
	}
}
