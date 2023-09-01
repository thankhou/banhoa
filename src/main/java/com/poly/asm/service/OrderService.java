package com.poly.asm.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.asm.entity.Order;
import com.poly.asm.entity.Product;


public interface OrderService {
	public List<Order> findAll() ;
	public Order create(JsonNode orderData) ;
	
	public Order findById(Long id) ;
	
	public List<Order> findByUsername(String username) ;
	
	public Order update(Order order) ;

	public void delete(Long id) ;
}
