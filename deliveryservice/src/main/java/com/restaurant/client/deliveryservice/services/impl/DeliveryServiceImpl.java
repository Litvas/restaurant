package com.restaurant.client.deliveryservice.services.impl;


import com.restaurant.client.deliveryservice.domain.Delivery;
import com.restaurant.client.deliveryservice.domain.Street;
import com.restaurant.client.deliveryservice.dto.DeliveryDto;
import com.restaurant.client.deliveryservice.mapper.DeliveryMapper;
import com.restaurant.client.deliveryservice.repository.DeliveryRepository;
import com.restaurant.client.deliveryservice.services.DeliveryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    @Override
    @Transactional
    public DeliveryDto saveDelivery(Delivery delivery) {
        Street street = delivery.getAddress().getStreet();
        street.setLocality(delivery.getAddress().getLocality());

        return deliveryMapper.toDto(deliveryRepository.save(delivery));
    }

    @Override
    public List<DeliveryDto> getDeliveriesByIds(List<Long> ids) {
        return deliveryMapper.toDtoList(deliveryRepository.findAllById(ids));
    }
}