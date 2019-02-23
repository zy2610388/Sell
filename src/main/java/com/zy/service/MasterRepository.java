package com.zy.service;

import com.zy.entities.Master;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MasterRepository {
    Page<Master> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
