package com.poly.asm.dao;


import com.poly.asm.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,String> {
}
