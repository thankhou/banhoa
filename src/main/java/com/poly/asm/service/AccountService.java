package com.poly.asm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.asm.entity.Account;
import com.poly.asm.entity.Role;

public interface AccountService{

	public List<Account> findAll();
	public Account findById(String username);
	public List<Account> getAdmininstrators();
	
   
}
