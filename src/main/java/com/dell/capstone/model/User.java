package com.dell.capstone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	private int Id;

	private String username;

	private String email;
	
	private String pwd;

	private int walletAmount;
	
	private boolean isAdmin;

	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(int walletAmount) {
		this.walletAmount = walletAmount;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User(String username, String email, String pwd, int walletAmount, boolean isAdmin) {
		super();
		this.username = username;
		this.email = email;
		this.pwd = pwd;
		this.walletAmount = walletAmount;
		this.isAdmin = isAdmin;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	


}
