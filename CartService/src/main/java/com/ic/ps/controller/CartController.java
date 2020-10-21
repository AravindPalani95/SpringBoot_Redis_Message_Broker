package com.ic.ps.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ic.ps.modal.Cart;
import com.ic.ps.modal.Item;
import com.ic.ps.service.CartService;

@RestController
public class CartController {

	private static Cart cart;
	
	@Autowired
	private CartService cartService;
	
	static {
		cart = new Cart();
		List<Item> itemList = new ArrayList<>();
		Item item1 = new Item();
		item1.setItemId(100);
		item1.setItemName("Laptop");
		item1.setQty(1);
		item1.setPrice(50000);
		Item item2 = new Item();
		item2.setItemId(522);
		item2.setItemName("Airpods");
		item2.setQty(2);
		item2.setPrice(6000.50);
		itemList.add(item1);
		itemList.add(item2);
		cart.setCartId(10012);
		cart.setItems(itemList);
	}
	
	@GetMapping(value = "/completeCart", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> publishCart() {
		cartService.publishCart(cart);
		return new ResponseEntity<String>("Processing Cart...",HttpStatus.OK);
	}
	
}
