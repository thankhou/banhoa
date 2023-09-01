package com.poly.asm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {
    @RequestMapping("/user/shopping-cart")
    public String view(){
        return "user/shopping-cart";
    }
    @RequestMapping("/user/product-detail")
    public String view2(){
        return "user/product-detail";
    }
}
