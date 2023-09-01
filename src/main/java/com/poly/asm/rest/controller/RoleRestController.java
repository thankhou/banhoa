package com.poly.asm.rest.controller;

import com.poly.asm.entity.Category;
import com.poly.asm.entity.Product;
import com.poly.asm.entity.Role;
import com.poly.asm.service.CategoryService;
import com.poly.asm.service.ProductService;
import com.poly.asm.service.RoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {
    @Autowired
    RoleService roleService;
    
    @GetMapping
    public List<Role> getAll() {
    	return roleService.findAll();
    }
}
