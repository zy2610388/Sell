package com.zy.service;

import com.zy.entities.Detail;

import java.util.List;

public interface OrderDetailRepository {
    List<Detail> findByOrderId(String orderId);
}
