package com.Quotation.dbService.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Table;

@Table(name = "User")
@DiscriminatorValue("User")
public class Users implements Serializable {

	private static final long serialVersionUID = 6616471943196113306L;

	@Column(name = "Username", nullable = false, unique = true)
	private String userName;

	@Column(name = "Password", nullable = false)
	private String password;

	@Column(name = "Email", nullable = false, unique = true)
	private String email;

	public Users() {
		super();
	}

	public Users(String username, String password, String email) {

		this.userName = username;
		this.password = password;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
