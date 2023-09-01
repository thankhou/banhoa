package com.poly.asm.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.asm.dao.AccountDAO;
import com.poly.asm.dao.OderDAO;
import com.poly.asm.dao.OderDetailDAO;
import com.poly.asm.dao.ProductDAO;
import com.poly.asm.dao.ShoppingCartDAO;
import com.poly.asm.entity.Account;
import com.poly.asm.entity.Order;
import com.poly.asm.entity.OrderDetail;
import com.poly.asm.entity.Product;
import com.poly.asm.service.OrderService;
import com.poly.asm.service.SessionService;




@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/checkout";
	}

	@RequestMapping("/user/product-detail/{id}")
	public String detail(Model model, @PathVariable("id") Long id) {
		model.addAttribute("order", orderService.findById(id));
		return "order/thankyou";
	}
	
	@RequestMapping("/user/index")
	public String detail(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername(username));
		return "user/index";
	}
}
