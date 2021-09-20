package com.dell.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dell.capstone.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	int findIdByEmail(String trim);


	

}
