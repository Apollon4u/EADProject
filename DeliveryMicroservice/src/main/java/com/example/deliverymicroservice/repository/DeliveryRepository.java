package com.example.deliverymicroservice.repository;

import com.example.deliverymicroservice.model.entity.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryOrder, Long> {
    DeliveryOrder getDeliveryOrderByOrderId(Long orderId);
}
