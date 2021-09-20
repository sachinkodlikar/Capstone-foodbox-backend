package com.dell.capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dell.capstone.entity.UserCartEntity;


@Repository
public interface UserCartRepository extends JpaRepository<UserCartEntity, Long> {

	List<UserCartEntity> findAllByUserIdAndItemId(int userid,int itemid);
	
	List<UserCartEntity> findAllByUserId(int userId);

	
}
