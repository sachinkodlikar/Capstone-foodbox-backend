package com.dell.capstone.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dell.capstone.entity.OrderEntity;
import com.dell.capstone.model.OrderRequest;
import com.dell.capstone.repository.OrderRepository;



@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class OrderController {
	@Autowired
	private OrderRepository orderRep;
	
	
	
	@PostMapping("/orders")
	public OrderEntity PlaceOrder(@RequestBody OrderRequest orderReq) throws Exception {
		OrderEntity oe = new OrderEntity();
		
		oe.setUserId(orderReq.getUserId());
		oe.setBillAmount(orderReq.getBillAmount());
		oe.setAddress(orderReq.getAddress());
		oe.setOrderDate(new Date());;
		OrderEntity oeResponse = orderRep.save(oe);
		return oeResponse;
	}
	
	
}
