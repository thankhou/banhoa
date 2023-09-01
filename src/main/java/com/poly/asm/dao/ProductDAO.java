package com.poly.asm.dao;


import com.poly.asm.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product,Integer> {
	@Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
    List<Product> findByKeywords(String keywords);
	
    @Query("SELECT p FROM Product p WHERE p.category.id=?1")
    List<Product> findCategoryId(String cid);
}
