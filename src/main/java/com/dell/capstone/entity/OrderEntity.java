package com.dell.capstone.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="ORDERS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name = "ORDER_ID")
	private long orderId;

	/** The status. */
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "ADDRESS")
	private String address;
	

	@Column(name = "BILL_AMOUNT")
	private int billAmount;
	
	@Column(name = "ORDER_DATE")
	private Date orderDate;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderEntity(long orderId, int userId, String address, int billAmount, Date orderDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.address = address;
		this.billAmount = billAmount;
		this.orderDate = orderDate;
	}

	public OrderEntity() {
		super();
	}

	

}
