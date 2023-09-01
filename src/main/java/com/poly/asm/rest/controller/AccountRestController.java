package com.poly.asm.rest.controller;

import com.poly.asm.entity.Account;
import com.poly.asm.entity.Category;
import com.poly.asm.entity.Product;
import com.poly.asm.entity.Role;
import com.poly.asm.service.AccountService;
import com.poly.asm.service.CategoryService;
import com.poly.asm.service.ProductService;
import com.poly.asm.service.RoleService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountService accountService;
	
	@GetMapping
	public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean> admin) {
		if(admin.orElse(false)) {
			return accountService.getAdmininstrators();
		}
		return accountService.findAll();
	}
	
	@GetMapping("{username}")
	public Account getOne(@PathVariable("username") String username) {
		return accountService.findById(username);
	}
}
