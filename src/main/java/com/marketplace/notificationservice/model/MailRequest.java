package com.marketplace.notificationservice.model;

public class MailRequest {
	
	@Override
	public String toString() {
		return "MailRequest [name=" + name + ", to=" + to + ", from=" + from + ", subject=" + subject + "]";
	}
	private String name;
	private String to;
	private String from;
	private String subject;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

}