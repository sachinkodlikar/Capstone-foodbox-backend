package com.dell.capstone.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity
@Table(name="USER_CART_ITEM")
public class UserCartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	
	//TODO added recently - not pushed
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name = "CART_ID")
	private int cartId;
	
	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "ITEM_ID")
	private int itemId;

	@Column(name = "ITEM_QUANTITY")
	private int itemQuantity;
	
	@Column(name = "ORDER_ID")
	private int orderId;
	
	
	@Column(name = "ORDER_PLACED")
	private boolean orderPlaced;


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public int getItemQuantity() {
		return itemQuantity;
	}


	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	public int getOrderId() {
		return orderId;
	}

	@JsonIgnore
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public boolean isOrderPlaced() {
		return orderPlaced;
	}


	public void setOrderPlaced(boolean orderPlaced) {
		this.orderPlaced = orderPlaced;
	}


	public UserCartEntity(int cartId, int userId, int itemId, int itemQuantity, int orderId, boolean orderPlaced) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
		this.orderId = orderId;
		this.orderPlaced = orderPlaced;
	}


	public UserCartEntity() {
		super();
	}






}
