package com.dell.capstone.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dell.capstone.entity.UserCartEntity;
import com.dell.capstone.repository.UserCartRepository;



@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserCartController {
	
	@Autowired
	private UserCartRepository userCartRep;
	
	
	@GetMapping("/usercart/{userId}")
	public List<UserCartEntity> getCartItems(@PathVariable int userId ) throws Exception {
		
		List<UserCartEntity> userCartItems = userCartRep.findAllByUserId(userId);
		
		if (userCartItems.size()>0) {
			 List<UserCartEntity> unplacedOrderList = userCartItems.stream()
			.filter(ui -> ui.isOrderPlaced()==false)
			.collect(Collectors.toList());
			 return unplacedOrderList;
		}
		return null;
		
	}
	
	@PostMapping("/usercart/order/{userId}/{orderId}")
	public void UpdateCartItems(@PathVariable int userId, @PathVariable int orderId ) throws Exception {
		
		List<UserCartEntity> userCartItems = userCartRep.findAllByUserId(userId);
		
		if (userCartItems.size()>0) {
			 List<UserCartEntity> unplacedOrderList = userCartItems.stream()
			.filter(ui -> ui.isOrderPlaced()==false)
			.filter(ui -> ui.getItemQuantity()>0)
			.collect(Collectors.toList());
			 
			 for (UserCartEntity uc : unplacedOrderList) {
					uc.setOrderPlaced(true);
					uc.setOrderId(orderId);
					userCartRep.save(uc);
				}
		}
		
		

		
	}
	
		
}
