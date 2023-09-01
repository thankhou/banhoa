package com.poly.asm.service.impl;

import com.poly.asm.dao.AccountDAO;
import com.poly.asm.dao.AuthoritiesDAO;
import com.poly.asm.dao.ProductDAO;
import com.poly.asm.dao.RoleDAO;
import com.poly.asm.entity.Account;
import com.poly.asm.entity.Authority;
import com.poly.asm.entity.Product;
import com.poly.asm.entity.Role;
import com.poly.asm.service.AccountService;
import com.poly.asm.service.AuthorityService;
import com.poly.asm.service.ProductService;
import com.poly.asm.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
AuthoritiesDAO dao;
	@Autowired
AccountDAO acdao;

@Override
public List<Authority> findAll() {
	// TODO Auto-generated method stub
	return dao.findAll();
}
@Override
public Authority create(Authority auth) {
	// TODO Auto-generated method stub
	return dao.save(auth);
}

@Override
public void delete(Integer id) {
	// TODO Auto-generated method stub
	dao.deleteById(id);
}

@Override
public List<Authority> findAuthoritiesOfAdministrators() {
	// TODO Auto-generated method stub
	List<Account> accounts = acdao.getAdministrators();
	return dao.authoritiesOf(accounts);
}


	
   
}
