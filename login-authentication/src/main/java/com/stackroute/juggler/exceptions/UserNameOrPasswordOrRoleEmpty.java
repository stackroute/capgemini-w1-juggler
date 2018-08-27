package com.stackroute.juggler.exceptions;

public class UserNameOrPasswordOrRoleEmpty extends Exception{
	private static final long serialVersionUID = 1L;

	String message;

	public UserNameOrPasswordOrRoleEmpty(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}
}