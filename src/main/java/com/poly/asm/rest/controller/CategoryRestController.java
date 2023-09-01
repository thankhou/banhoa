package com.poly.asm.rest.controller;

import com.poly.asm.entity.Category;
import com.poly.asm.entity.Product;
import com.poly.asm.service.CategoryService;
import com.poly.asm.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;
    
    @GetMapping()
    public List<Category> getAll() {
    	return categoryService.findAll();
    }
}
