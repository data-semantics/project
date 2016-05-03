package com.tutorial;

public class ResultStructure {
	private String subject;
	private String property;
	private String object;
	private String body;
	private String text;
	private String creatorAnno;
	private String creatorName;
	private String queryName;
	private String queryValue;
	private String bookTitle;
	private String bookUrl;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookUrl() {
		return bookUrl;
	}

	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQueryValue() {
		return queryValue;
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}

	public String getCreatorAnno() {
		return creatorAnno;
	}

	public void setCreatorAnno(String creatorAnno) {
		this.creatorAnno = creatorAnno;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public ResultStructure(String subject, String object) {
		this.queryName = object;
		this.queryValue = subject;
	}

	public ResultStructure() {
	}

}
