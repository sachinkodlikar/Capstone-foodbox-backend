package com.dell.capstone.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Item  {


	private long itemId;

	private String itemName;

	private String description;
	
	private String image;

	private int availableQuantity;

	private int price;
	
	private int discount;
	
	private boolean cartItemAvailable;
	
	private int cartItemQuantity;
	
	

	
	public long getItemId() {
		return  itemId;
	}




	public void setItemId(long itemId) {
		this.itemId = itemId;
	}




	public String getItemName() {
		return itemName;
	}




	public void setItemName(String itemName) {
		this.itemName = itemName;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public int getAvailableQuantity() {
		return availableQuantity;
	}




	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}




	public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public int getDiscount() {
		return discount;
	}




	public void setDiscount(int discount) {
		this.discount = discount;
	}




	public boolean isCartItemAvailable() {
		return cartItemAvailable;
	}




	public void setCartItemAvailable(boolean cartItemAvailable) {
		this.cartItemAvailable = cartItemAvailable;
	}




	public int getCartItemQuantity() {
		return cartItemQuantity;
	}




	public void setCartItemQuantity(int cartItemQuantity) {
		this.cartItemQuantity = cartItemQuantity;
	}




	public Item(long itemId, String itemName, String description, String image, int availableQuantity, int price,
			int discount, boolean cartItemAvailable, int cartItemQuantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.description = description;
		this.image = image;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.discount = discount;
		this.cartItemAvailable = cartItemAvailable;
		this.cartItemQuantity = cartItemQuantity;
	}




	public Item() {
		super();
	}



}
