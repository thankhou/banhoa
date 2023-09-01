package com.poly.asm.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.asm.dao.OderDAO;
import com.poly.asm.dao.OderDetailDAO;
import com.poly.asm.entity.Order;
import com.poly.asm.entity.OrderDetail;
import com.poly.asm.entity.Product;
import com.poly.asm.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OderDAO dao;
	@Autowired
	OderDetailDAO ddao;
	@Override
	public List<Order> findAll() {
		return dao.findAll();
	}

	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		Order order = mapper.convertValue(orderData, Order.class);
		dao.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"),type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		return order;
	}

	@Override
	public Order findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Order update(Order order) {
		return dao.save(order);
	}

	

}
