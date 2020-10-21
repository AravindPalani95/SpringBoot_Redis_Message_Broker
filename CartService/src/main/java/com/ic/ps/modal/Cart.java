package com.ic.ps.modal;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable{

	private static final long serialVersionUID = 5000872660912545852L;

	private int cartId;
	
	private List<Item> items;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
