package com.arpanbags.orders.arpanbagsorders.repository;

import com.arpanbags.orders.arpanbagsorders.entity.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends MongoRepository<Orders, Long> {
}
