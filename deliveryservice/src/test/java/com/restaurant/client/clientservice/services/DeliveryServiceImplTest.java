package com.restaurant.client.clientservice.services;

import com.restaurant.client.deliveryservice.domain.Delivery;
import com.restaurant.client.deliveryservice.dto.DeliveryDto;
import com.restaurant.client.deliveryservice.mapper.DeliveryMapper;
import com.restaurant.client.deliveryservice.repository.DeliveryRepository;
import com.restaurant.client.deliveryservice.services.impl.DeliveryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class DeliveryServiceImplTest {

    @Mock
    private DeliveryRepository deliveryRepository;

    @Mock
    private DeliveryMapper deliveryMapper;

    @InjectMocks
    private DeliveryServiceImpl deliveryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getDeliveriesByIds_Success() {
        Delivery d1 = new Delivery();
        d1.setId(1L);
        Delivery d2 = new Delivery();
        d2.setId(2L);
        List<Delivery> deliveryList = List.of(d1, d2);
        DeliveryDto dto1 = new DeliveryDto();
        DeliveryDto dto2 = new DeliveryDto();
        List<DeliveryDto> dtoList = List.of(dto1, dto2);
        when(deliveryRepository.findAllById(List.of(1L, 2L))).thenReturn(deliveryList);
        when(deliveryMapper.toDtoList(deliveryList)).thenReturn(dtoList);
        List<DeliveryDto> result = deliveryService.getDeliveriesByIds(List.of(1L, 2L));
        assertEquals(2, result.size());
    }

    @Test
    void saveDelivery_NullAddress_ThrowsException() {
        Delivery delivery = new Delivery();
        delivery.setAddress(null);
        assertThrows(NullPointerException.class, () -> deliveryService.saveDelivery(delivery));
    }
}