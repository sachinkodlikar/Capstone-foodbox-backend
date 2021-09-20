package com.dell.capstone.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="ITEMS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name = "ITEM_ID")
	private long itemId;

	/** The status. */
	@Column(name = "ITEM_NAME")
	private String itemName;

	@Column(name = "ITEM_DESCRIPTION")
	private String description;
	
	
	@Column(name = "IMAGE")
	private String image;

	@Column(name = "AVAILABLE_QUANTITY")
	private int availableQuantity;
	
	@Column(name = "PRICE")
	private int price;
	
	@Column(name = "DISCOUNT")
	private int discount;

	public long getItemId() {
		return itemId;
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

	public ItemEntity(String itemName, String description, String image, int availableQuantity, int price,
			int discount) {
		super();
		this.itemName = itemName;
		this.description = description;
		this.image = image;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.discount = discount;
	}

	public ItemEntity() {
		super();
	}



}
