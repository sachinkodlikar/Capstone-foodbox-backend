package com.dell.capstone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.dell.capstone.entity.UserEntity;
import com.dell.capstone.model.LoginResponse;
import com.dell.capstone.model.User;
import com.dell.capstone.repository.UserRepository;



@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {
	@Autowired
	private UserRepository userRep;
	
	
	@GetMapping("/users")
	public List<User> getUsers() throws Exception {
		List<UserEntity> usersList = userRep.findAll();
		List<User> users = new ArrayList<User>();
		for (UserEntity userEntity : usersList) {
			User usr = new User();
			BeanUtils.copyProperties(userEntity, usr);
			users.add(usr);
		}
		return users;
	}
	
	@PostMapping("/register")
	public String addUser(@RequestBody UserEntity user) throws Exception {
		user.setAdmin(false);
		user.setWalletAmount(1000);
		userRep.save(user);
		return user.getEmail() + " added successfully.";
	}
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody UserEntity user) throws Exception {
		List<UserEntity> usersList = userRep.findAll();
		LoginResponse lr = new LoginResponse();
		for (UserEntity userEntity : usersList) {
			if (userEntity.getEmail().trim().equalsIgnoreCase(user.getEmail().trim()) && userEntity.getPwd().equals(user.getPwd())) {
				lr.setLoginStatus(true);
				lr.setId(userEntity.getId());
				lr.setAdmin(userEntity.isAdmin());
				lr.setWallet(userEntity.getWalletAmount());
				break;
			}
		}
		return lr;
	}
	
	@PostMapping("/updatewallet/{userId}/{billAmount}")
	public void updatewallet(@PathVariable int userId, @PathVariable int billAmount) throws Exception {
		List<UserEntity> usersList = userRep.findAll();
		
		for (UserEntity userEntity : usersList) {
			if (userEntity.getId()==userId) {
				userEntity.setWalletAmount(userEntity.getWalletAmount()-billAmount);
				userRep.save(userEntity);
				break;
			}
		}
		
	}
	
	@PostMapping("/updateAdminwallet/{billAmount}")
	public void updateAdminwallet( @PathVariable int billAmount) throws Exception {
		List<UserEntity> usersList = userRep.findAll();
		
		for (UserEntity userEntity : usersList) {
			if (userEntity.getId()==1) {
				userEntity.setWalletAmount(userEntity.getWalletAmount()+billAmount);
				userRep.save(userEntity);
				break;
			}
		}
		
	}
	
	
		
}
