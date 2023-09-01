package com.poly.asm.dao;


import com.poly.asm.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, String> {
}
