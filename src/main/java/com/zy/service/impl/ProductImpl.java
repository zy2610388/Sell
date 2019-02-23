package com.zy.service.impl;

import com.zy.dao.ProductInfoMapper;
import com.zy.entities.ProductInfo;
import com.zy.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductInfoService {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> finUpAll() {
        return productInfoMapper.selectByExample(null);
    }
}
