package com.restaurant.client.deliveryservice.services;

import com.restaurant.client.deliveryservice.domain.Delivery;
import com.restaurant.client.deliveryservice.dto.DeliveryDto;

import java.util.List;

public interface DeliveryService {
    DeliveryDto saveDelivery(Delivery delivery);

    List<DeliveryDto> getDeliveriesByIds(List<Long> ids);
}