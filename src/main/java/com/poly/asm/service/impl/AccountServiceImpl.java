package com.poly.asm.service.impl;

import com.poly.asm.dao.AccountDAO;
import com.poly.asm.dao.ProductDAO;
import com.poly.asm.dao.RoleDAO;

import com.poly.asm.entity.Account;
import com.poly.asm.entity.Product;
import com.poly.asm.entity.Role;
import com.poly.asm.service.AccountService;
import com.poly.asm.service.ProductService;
import com.poly.asm.service.RoleService;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
AccountDAO dao;

@Override
public List<Account> findAll() {
	// TODO Auto-generated method stub
	return dao.findAll();
}

@Override
public Account findById(String username) {
	// TODO Auto-generated method stub
	return dao.findById(username).get();
}

@Override
public List<Account> getAdmininstrators() {
	// TODO Auto-generated method stub
	return dao.getAdministrators();
}

}
