package com.example.model;

public class FriendApplicationException {
	
	private String detailMessage;
	private Throwable stackTrace;
	
	
	public FriendApplicationException() {}

	public FriendApplicationException(String message) {
		this.detailMessage=message;
	}

	public FriendApplicationException(String message,Throwable t) {
		this.stackTrace = t.fillInStackTrace();
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public Throwable getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(Throwable stackTrace) {
		this.stackTrace = stackTrace;
	}
	
	
}
