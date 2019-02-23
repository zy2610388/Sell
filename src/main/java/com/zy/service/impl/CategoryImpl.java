package com.zy.service.impl;

import com.zy.dao.CategoryMapper;
import com.zy.entities.Category;
import com.zy.entities.CategoryExample;
import com.zy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public Category findOne(Integer categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public List<Category> findAll() {
        return categoryMapper.selectByExample(null);
    }

    @Override
    public List<Category> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andCategoryTypeIn(categoryTypeList);
        List<Category> categoriesList = categoryMapper.selectByExample(categoryExample);
        //return categoryMapper.selectByExample(null);
        return categoriesList;
    }

    @Override
    public Category save(Category category) {
        return null;
    }
}
