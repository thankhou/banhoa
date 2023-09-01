package com.poly.asm.controller;


import com.poly.asm.dao.ProductDAO;
import com.poly.asm.entity.Product;
import com.poly.asm.service.ProductService;
import com.poly.asm.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
	SessionService sessionService;
    @Autowired
	ProductDAO dao;


    @RequestMapping({"/product/list", "/home/index"})
    public String list(Model model, @RequestParam("cid")Optional<String> cid){
        if (cid.isPresent()){
            List<Product> list = productService.findCategoryId(cid.get());
            model.addAttribute("items",list);
        }else {
            List<Product> list = productService.findAll();
            model.addAttribute("items",list);
        }

        return "user/index";
    }
	@RequestMapping("/product/search")
	public String search(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String keywords = kw.orElse(sessionService.getAttribute("keywords"));
		sessionService.setAttribute("keywords", keywords);

		List<Product> list = dao.findByKeywords("%" + keywords + "%");
		model.addAttribute("keywords", keywords);
		model.addAttribute("items", list);
		return "user/index";
	}
    @RequestMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Product item = productService.findById(id);
        model.addAttribute("item",item);
        return "user/product-detail";
    }
}
