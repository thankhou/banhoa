package com.poly.asm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String Home(){
        return "redirect:/home/index";
    }
    @RequestMapping({"/admin","/admin/home/index"})
    public String admin(){
        return "redirect:/assets/admin/index.html";
    }
   @RequestMapping("/home/about")
   public String about() {
	   return"user/about";
   }
}
