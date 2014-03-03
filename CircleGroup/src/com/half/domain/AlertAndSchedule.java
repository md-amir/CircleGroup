package com.half.domain;

public class AlertAndSchedule {
		
	
	private String subject;
	private String message;
	private String messageFrom;
	private String messageTo;
	private boolean isAlert;
	private boolean isSchedule;
	private String author;
	
		
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageFrom() {
		return messageFrom;
	}
	public void setMessageFrom(String messageFrom) {
		this.messageFrom = messageFrom;
	}
	public String getMessageTo() {
		return messageTo;
	}
	public void setMessageTo(String messageTo) {
		this.messageTo = messageTo;
	}
	public boolean isAlert() {
		return isAlert;
	}
	public void setAlert(boolean isAlert) {
		this.isAlert = isAlert;
	}
	public boolean isSchedule() {
		return isSchedule;
	}
	public void setSchedule(boolean isSchedule) {
		this.isSchedule = isSchedule;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
