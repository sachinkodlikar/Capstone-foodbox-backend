package com.dell.capstone.model;

public class OrderRequest {

	private int userId;
	
	private String address;
	
	private int billAmount;
	
	

	


	public int getUserId() {
		return userId;
	}






	public void setUserId(int userId) {
		this.userId = userId;
	}






	public String getAddress() {
		return address;
	}






	public void setAddress(String address) {
		this.address = address;
	}






	public int getBillAmount() {
		return billAmount;
	}






	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}






	public OrderRequest(int userId, String address, int billAmount) {
		super();
		this.userId = userId;
		this.address = address;
		this.billAmount = billAmount;
	}






	public OrderRequest() {
		super();
	}

	
	
	


}
