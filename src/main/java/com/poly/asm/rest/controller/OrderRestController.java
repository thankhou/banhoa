package com.poly.asm.rest.controller;

import java.security.Timestamp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.asm.dao.AccountDAO;
import com.poly.asm.dao.ProductDAO;
import com.poly.asm.entity.Account;
import com.poly.asm.entity.Order;
import com.poly.asm.entity.Product;
import com.poly.asm.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/historys")
public class OrderRestController {
	
	@Autowired
	OrderService orderService;
	@Autowired
	AccountDAO accdao;
	@Autowired
	ProductDAO prodao;
	@GetMapping
	public List<Order> getAll() {
		return orderService.findAll();
	}
	@GetMapping("{id}")
	public Order getOne(@PathVariable("id") Long id) {
		return orderService.findById(id);
	}
	
	@PutMapping("{id}")
	public Order put(@PathVariable("id") Long id, @RequestBody Order order) {
		return orderService.update(order);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		orderService.delete(id);
	}
	
	@PostMapping
	public Order purchase(@RequestBody JsonNode orderData) {
		
		return orderService.create(orderData);
	}

}
