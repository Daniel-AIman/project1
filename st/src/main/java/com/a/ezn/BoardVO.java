package com.a.ezn;

public class BoardVO {
	private int sno;
	private String title;
	private String body;
	private String writer;
	private String rdate;
	
	public int getSno() {
		return sno;
	}
	public String getTitle() {
		return title;
	}
	public String getBody() {
		return body;
	}
	public String getWriter() {
		return writer;
	}
	public String getRdate() {
		return rdate;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	
}
