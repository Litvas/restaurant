package com.restaurant.client.clientservice.mapper;

import com.restaurant.client.deliveryservice.domain.*;
import com.restaurant.client.deliveryservice.dto.AddressDto;
import com.restaurant.client.deliveryservice.dto.DeliveryDto;
import com.restaurant.client.deliveryservice.mapper.DeliveryMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryMapperTest {

    private final DeliveryMapper deliveryMapper = Mappers.getMapper(DeliveryMapper.class);

    @Test
    void testMapAddress() {
        Locality locality = new Locality();
        locality.setName("Springfield");

        Street street = new Street();
        street.setName("Evergreen Terrace");

        Address address = new Address();
        address.setNumber("742");
        address.setIsPrivateHome(true);
        address.setCorpus("1");
        address.setEntrance("B");
        address.setFloor("2");
        address.setApartment("5");
        address.setLocality(locality);
        address.setStreet(street);

        AddressDto dto = deliveryMapper.mapAddress(address);

        assertEquals("Springfield", dto.getLocalityName());
        assertEquals("Evergreen Terrace", dto.getStreetName());
        assertEquals("742", dto.getNumber());
        assertTrue(dto.getIsPrivateHome());
        assertEquals("1", dto.getCorpus());
        assertEquals("B", dto.getEntrance());
        assertEquals("2", dto.getFloor());
        assertEquals("5", dto.getApartment());
    }

    @Test
    void testToDto() {
        Locality locality = new Locality();
        locality.setName("TestTown");

        Street street = new Street();
        street.setName("Main Street");

        Address address = new Address();
        address.setLocality(locality);
        address.setStreet(street);
        address.setNumber("1");
        address.setIsPrivateHome(false);

        Delivery delivery = new Delivery();
        delivery.setAddress(address);

        DeliveryDto dto = deliveryMapper.toDto(delivery);

        assertNotNull(dto.getAddress());
        assertEquals("Main Street", dto.getAddress().getStreetName());
        assertEquals("TestTown", dto.getAddress().getLocalityName());
        assertEquals("1", dto.getAddress().getNumber());
        assertFalse(dto.getAddress().getIsPrivateHome());
    }

    @Test
    void testToDtoList() {
        Delivery delivery1 = new Delivery();
        delivery1.setAddress(new Address());

        Delivery delivery2 = new Delivery();
        delivery2.setAddress(new Address());

        List<DeliveryDto> result = deliveryMapper.toDtoList(List.of(delivery1, delivery2));

        assertEquals(2, result.size());
        assertNotNull(result.get(0));
        assertNotNull(result.get(1));
    }

}
