package com.poly.asm.dao;

import java.util.Collection;

import com.poly.asm.entity.Product;


public interface ShoppingCartDAO {

	double getAmount();

	void clear();

	int getCount();

	void remove(int productId);

	void update(int productId, int quantity);

	void add(Product item);

	Collection<Product> getAll();

}
