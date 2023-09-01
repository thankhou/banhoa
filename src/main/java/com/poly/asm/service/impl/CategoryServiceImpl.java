package com.poly.asm.service.impl;


import com.poly.asm.dao.CategoryDAO;
import com.poly.asm.entity.Category;
import com.poly.asm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDAO cdao;
    @Override
    public List<Category> findAll() {
        return cdao.findAll();
    }
}
