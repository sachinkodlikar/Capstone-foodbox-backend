package com.dell.capstone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dell.capstone.entity.ItemEntity;
import com.dell.capstone.entity.UserCartEntity;
import com.dell.capstone.model.Item;
import com.dell.capstone.repository.ItemRepository;
import com.dell.capstone.repository.UserCartRepository;



@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ItemController {
	@Autowired
	private ItemRepository itemRep;

	@Autowired
	private UserCartRepository cartRep;



	@GetMapping("/items/cust/{userId}")
	public List<Item> getAllItems(@PathVariable int userId) throws Exception {
		List<ItemEntity> itemList = itemRep.findAll();
		List<Item> itemsList = new ArrayList<Item>();
		
		for (ItemEntity itemEntity : itemList) {
			
			Item itm = new Item();
			BeanUtils.copyProperties(itemEntity, itm);
			 List<UserCartEntity> cartItems = cartRep.findAllByUserIdAndItemId(userId, (int) itm.getItemId());
			 for (UserCartEntity citems : cartItems) {
				if (itemEntity.getItemId()==citems.getItemId()  && citems.getItemQuantity()>0 ) {
					itm.setCartItemAvailable(true);
					itm.setCartItemQuantity(citems.getItemQuantity());
				}
			}
			itemsList.add(itm);
		}

		
		// Items available in cart and item quantity 


		return itemsList;
	}

	
	

	@GetMapping("/items/cust/cart/{userId}")
	public List<Item> getAllCartItems(@PathVariable int userId) throws Exception {
		List<ItemEntity> itemList = itemRep.findAll();
		List<Item> itemsList = new ArrayList<Item>();
		
		for (ItemEntity itemEntity : itemList) {
			
			Item itm = new Item();
			BeanUtils.copyProperties(itemEntity, itm);
			 List<UserCartEntity> cartItems = cartRep.findAllByUserIdAndItemId(userId, (int) itm.getItemId());
			 for (UserCartEntity citems : cartItems) {
				if (itemEntity.getItemId()==citems.getItemId()  && citems.getItemQuantity()>0 ) {
					itm.setCartItemAvailable(true);
					itm.setCartItemQuantity(citems.getItemQuantity());
					itemsList.add(itm);
				}
			}
//			itemsList.add(itm);
		}
		return itemsList;
	}
	
	@PostMapping("/items")
	public String addItem(@RequestBody ItemEntity item) throws Exception {
		itemRep.save(item);
		return item.getItemName() + " added successfully.";
	}


	@DeleteMapping("/items/{id}")
	public void deleteItem(@PathVariable long id) throws Exception {
		itemRep.deleteById(id);
		System.out.println("Items with Id "+ id +" is deleted.");
	}


	@GetMapping("/items/{id}")
	public ItemEntity getItemById(@PathVariable long id) throws Exception {
		ItemEntity item = itemRep.findAllByItemId(id);
		return item;

	}



	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	@PostMapping("/items/addCart/{userId}/{itemId}")
	public String addCartItem(@PathVariable int userId,@PathVariable int itemId) throws Exception {
		
		List<UserCartEntity> citems = cartRep.findAllByUserIdAndItemId(userId, itemId);
		UserCartEntity uce = new UserCartEntity();
		if (citems.isEmpty()) {
			
			uce.setItemId(itemId);
			uce.setUserId(userId);
			uce.setItemQuantity(1);
//			cartRep.save(uce);
		} else {
			uce = citems.get(0);
			uce.setItemQuantity(1);	
		}
//		UserCartEntity uce = new UserCartEntity();
//		uce.setItemId(itemId);
//		uce.setUserId(userId);
//		uce.setItemQuantity(1);
		cartRep.save(uce);
		return " added successfully.";
	}

	@GetMapping("/items/cartItems/{userId}")
	public List<UserCartEntity> getCartItems(@PathVariable int userId) throws Exception {
		List<UserCartEntity> uce = cartRep.findAllByUserId(userId);
		return uce;
	}
	
	
	@PostMapping("/items/updateCart/{userId}/{itemId}/{action}")
	public String UpdateCartItem(@PathVariable int userId,@PathVariable int itemId, @PathVariable String action) throws Exception {
		List<UserCartEntity> cartitem = cartRep.findAllByUserIdAndItemId(userId, itemId);
		
		if (action.equalsIgnoreCase("plus")) {
			cartitem.get(0).setItemQuantity(cartitem.get(0).getItemQuantity()+1);
		} else if(action.equalsIgnoreCase("minus")) {
			cartitem.get(0).setItemQuantity(cartitem.get(0).getItemQuantity()-1);
		}
		
		cartRep.save(cartitem.get(0));
		return " Item Quantity updated successfully.";
	}

}
