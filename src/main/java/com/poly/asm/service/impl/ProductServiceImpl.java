package com.poly.asm.service.impl;


import com.poly.asm.dao.ProductDAO;
import com.poly.asm.entity.Product;
import com.poly.asm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO pdao;

    @Override
    public List<Product> findAll() {
        return pdao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return pdao.findById(id).get();
    }

    @Override
    public List<Product> findCategoryId(String cid) {
        return pdao.findCategoryId(cid);
    }

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		pdao.deleteById(id);
	}
}
