package com.poly.asm.service;

import java.util.List;

import com.poly.asm.entity.Account;
import com.poly.asm.entity.Authority;
import com.poly.asm.entity.Role;

public interface AuthorityService {

public List<Authority> findAll();
public Authority create(Authority auth);
public void delete(Integer id);
public List<Authority> findAuthoritiesOfAdministrators();
}
