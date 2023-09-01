package com.poly.asm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.asm.dao.OderDAO;
import com.poly.asm.entity.Account;
import com.poly.asm.entity.Order;
import com.poly.asm.service.SessionService;


@Controller

public class AdminOrderController {
	@Autowired
	OderDAO orderDAO;
	@Autowired
	SessionService sessionService;


	@RequestMapping("/history")
	public String index(Model model, @ModelAttribute("orderItem") Order order) {
		model.addAttribute("orderItems", orderDAO.findAllOrderByCreateDateDesc());
		
		return "orderAdmin";
	}
	

	

}
