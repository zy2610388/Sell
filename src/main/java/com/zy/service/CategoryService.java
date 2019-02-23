package com.zy.service;

import com.zy.entities.Category;

import java.util.List;

public interface CategoryService {
    Category findOne(Integer categoryId);
    List<Category> findAll();
    List<Category> findByCategoryTypeIn(List<Integer> categoryTypeList);
    Category save(Category category);
}
