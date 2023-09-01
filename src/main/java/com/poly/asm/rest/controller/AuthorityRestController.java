package com.poly.asm.rest.controller;

import com.poly.asm.entity.Authority;
import com.poly.asm.entity.Category;
import com.poly.asm.entity.Product;
import com.poly.asm.entity.Role;
import com.poly.asm.service.AuthorityService;
import com.poly.asm.service.CategoryService;
import com.poly.asm.service.ProductService;
import com.poly.asm.service.RoleService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {
	@Autowired
	AuthorityService authorityService;
	
	@GetMapping
	public List<Authority> findAll(@RequestParam("admin") Optional<Boolean> admin) {
		if(admin.orElse(false)) {
			return authorityService.findAuthoritiesOfAdministrators();
		}
		return authorityService.findAll();
	}
	
	@PostMapping
	public Authority post(@RequestBody Authority auth) {
		return authorityService.create(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		authorityService.delete(id);
	}
}