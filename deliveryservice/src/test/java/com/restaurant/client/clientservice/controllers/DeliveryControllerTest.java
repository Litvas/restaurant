package com.restaurant.client.clientservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.client.deliveryservice.controllers.DeliveryController;
import com.restaurant.client.deliveryservice.domain.Address;
import com.restaurant.client.deliveryservice.domain.Delivery;
import com.restaurant.client.deliveryservice.dto.AddressDto;
import com.restaurant.client.deliveryservice.dto.DeliveryDto;
import com.restaurant.client.deliveryservice.services.DeliveryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeliveryController.class)
@ContextConfiguration(classes = com.restaurant.client.deliveryservice.DeliveryServiceApplication.class)
class DeliveryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeliveryService deliveryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSaveDelivery_Success() throws Exception {
        Delivery delivery = new Delivery();
        Address address = new Address();
        delivery.setAddress(address);

        DeliveryDto responseDto = new DeliveryDto();
        AddressDto addressDto = new AddressDto();
        responseDto.setAddress(addressDto);

        Mockito.when(deliveryService.saveDelivery(any(Delivery.class)))
                .thenReturn(responseDto);

        mockMvc.perform(post("/api/v1/deliveries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(delivery)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetDeliveriesByIds_Success() throws Exception {
        DeliveryDto dto1 = new DeliveryDto();
        DeliveryDto dto2 = new DeliveryDto();

        Mockito.when(deliveryService.getDeliveriesByIds(eq(List.of(1L, 2L))))
                .thenReturn(List.of(dto1, dto2));

        mockMvc.perform(get("/api/v1/deliveries")
                        .param("ids", "1", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));
    }

    @Test
    void testGetDeliveriesByIds_MissingParam() throws Exception {
        mockMvc.perform(get("/api/v1/deliveries"))
                .andExpect(status().isBadRequest());
    }
}
