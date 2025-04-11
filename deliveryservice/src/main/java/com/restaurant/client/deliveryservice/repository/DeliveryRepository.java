package com.restaurant.client.deliveryservice.repository;

import com.restaurant.client.deliveryservice.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
