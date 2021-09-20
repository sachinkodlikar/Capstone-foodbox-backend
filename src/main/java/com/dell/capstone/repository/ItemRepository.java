package com.dell.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dell.capstone.entity.ItemEntity;


@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
	
	ItemEntity findAllByItemId(long id);
}
