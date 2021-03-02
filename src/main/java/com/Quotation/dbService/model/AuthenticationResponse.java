package com.Quotation.dbService.model;

public class AuthenticationResponse {

	private String jwt;

	private String time;



	public AuthenticationResponse() {
	}

	public AuthenticationResponse(String jwt, String time) {
		this.jwt = jwt;
		this.time = time;
	}

	public String getJwt() {
		return jwt;
	}

	public String getLocalDateTime() {
		return time;
	}

}
