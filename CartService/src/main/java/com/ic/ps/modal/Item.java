package com.ic.ps.modal;

import java.io.Serializable;

public class Item implements Serializable{
	
	private static final long serialVersionUID = 1075666589471659281L;

	private int itemId;
	
	private String itemName;
	
	private int qty;
	
	private double price;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
