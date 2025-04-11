package com.restaurant.client.deliveryservice.controllers;

import com.restaurant.client.deliveryservice.domain.Delivery;
import com.restaurant.client.deliveryservice.dto.DeliveryDto;
import com.restaurant.client.deliveryservice.services.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping
    public DeliveryDto saveDelivery(@RequestBody Delivery delivery) {
        return deliveryService.saveDelivery(delivery);
    }

    @GetMapping
    public List<DeliveryDto> getDeliveriesByIds(@RequestParam List<Long> ids) {
        return deliveryService.getDeliveriesByIds(ids);
    }
}