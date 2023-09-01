package com.poly.asm.service;



import com.poly.asm.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findCategoryId(String cid);
    Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

}
