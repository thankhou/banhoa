package com.poly.asm.service.impl;

import com.poly.asm.dao.ProductDAO;
import com.poly.asm.dao.RoleDAO;
import com.poly.asm.entity.Product;
import com.poly.asm.entity.Role;
import com.poly.asm.service.ProductService;
import com.poly.asm.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
RoleDAO dao;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
   
}
