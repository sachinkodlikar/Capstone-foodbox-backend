package com.dell.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dell.capstone.entity.OrderEntity;


@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
