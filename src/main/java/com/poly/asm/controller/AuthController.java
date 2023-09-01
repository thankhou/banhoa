package com.poly.asm.controller;

import com.poly.asm.dao.AccountDAO;
import com.poly.asm.entity.Account;
import com.poly.asm.entity.Authority;
import com.poly.asm.entity.Role;
import com.poly.asm.service.AccountService;
import com.poly.asm.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class AuthController {
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	UserService userService;

	@RequestMapping({"/login","/user/login"})
	public String loginForm(Model model) {
		return "user/login";
	}

	@RequestMapping("/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công!");
		return "redirect:/home/index";
	}

	@RequestMapping("/login/error")
	public String error(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập!");
		return "forward:/login";
	}

	@RequestMapping("/logout/success")
	public String logoff(Model model ) {
		model.addAttribute("message", "Đăng xuất thành công!");

		return "redirect:/home/index";
	}

	@RequestMapping("/access/denied")
	public String denied(Model model) {
		model.addAttribute("message", "Bạn không có quyền truy xuất!");
		return "/login";
	}

	@RequestMapping("/user/register")
	public String register() {
		return "user/register";
	}


	@RequestMapping("/register/success")
	public String register1(Model model, @RequestParam String username, @RequestParam String password,
			@RequestParam String fullname, @RequestParam String email) {
		if (!accountDAO.findById(username).isEmpty()) {
			model.addAttribute("error", "Vui lòng đặt tên username khác!");
		} else {
			Account user = new Account();
			user.setUsername(username);
			user.setPassword(password);
			user.setFullname(fullname);
			user.setEmail(email);
			accountDAO.save(user);
			model.addAttribute("message", "Đăng kí thành công");
		}
		return "redirect:/home/index";
	}

	@RequestMapping("/oauth2/login/success")
	public String success(OAuth2AuthenticationToken oauth2) {
		userService.loginFromOAuth2(oauth2);
		return "redirect:/home/index";
	}
	
	@CrossOrigin("*")
	@ResponseBody
	@RequestMapping("/rest/security/authentication")
	public Object getAuthentication(HttpSession session) {
		return session.getAttribute("authentication");
	}
}
