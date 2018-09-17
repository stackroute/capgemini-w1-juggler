package com.stackroute.juggler.emailservice.domain;

import java.util.Arrays;

public class EmailDetails {
	 private String[] toEmailId;	 
	 private String[] emailCc; 	 
	 private String subject;	 
	 private String body;
	 
	public EmailDetails() {
		super();
	}
	public EmailDetails(String[] toEmailId, String[] emailCc, String subject, String body) {
		super();
		this.toEmailId = toEmailId;
		this.emailCc = emailCc;
		this.subject = subject;
		this.body = body;
	}
	public String[] getToEmailId() {
		return toEmailId;
	}
	public void setToEmailId(String[] toEmailId) {
		this.toEmailId = toEmailId;
	}
	public String[] getEmailCc() {
		return emailCc;
	}
	public void setEmailCc(String[] emailCc) {
		this.emailCc = emailCc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "EmailDetails [toEmailId=" + toEmailId + ", emailCc=" + Arrays.toString(emailCc) + ", subject=" + subject
				+ ", body=" + body + "]";
	}
	 
	 
}
