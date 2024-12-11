package com.arpanbags.consumer.arpanbagskafkaconsumer.repository;

import com.arpanbags.consumer.arpanbagskafkaconsumer.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}