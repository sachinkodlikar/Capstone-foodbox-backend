package com.dell.capstone.model;

public class LoginResponse {

	private int Id;
	
	private boolean loginStatus =false;
	
	private boolean admin = false;
	
	private int wallet;
	
	

	public int getWallet() {
		return wallet;
	}



	public void setWallet(int wallet) {
		this.wallet = wallet;
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		this.Id = id;
	}



	public boolean isLoginStatus() {
		return loginStatus;
	}



	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}



	public boolean isAdmin() {
		return admin;
	}



	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	

	public LoginResponse(int id, boolean loginStatus, boolean admin) {
		super();
		this.Id = id;
		this.loginStatus = loginStatus;
		this.admin = admin;
	}



	public LoginResponse(int id, boolean loginStatus, boolean admin, int wallet) {
		super();
		this.Id = id;
		this.loginStatus = loginStatus;
		this.admin = admin;
		this.wallet = wallet;
	}



	public LoginResponse() {
		super();
	}

	
	
	


}
