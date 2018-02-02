package com.example.sell.repository;

import com.example.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    public Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);
}
