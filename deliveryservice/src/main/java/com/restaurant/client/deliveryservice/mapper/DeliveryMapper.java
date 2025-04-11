package com.restaurant.client.deliveryservice.mapper;


import com.restaurant.client.deliveryservice.domain.Address;
import com.restaurant.client.deliveryservice.domain.Delivery;
import com.restaurant.client.deliveryservice.dto.AddressDto;
import com.restaurant.client.deliveryservice.dto.DeliveryDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    @Named("toDto")
    @Mapping(target="address", expression = "java(mapAddress(delivery.getAddress()))")
    DeliveryDto toDto(Delivery delivery);


    @IterableMapping(qualifiedByName = "toDto")
    List<DeliveryDto> toDtoList(List<Delivery> deliveryList);

    @Mapping(target="localityName", source = "locality.name")
    @Mapping(target="streetName", source = "street.name")
    @Mapping(target="number", source = "number")
    @Mapping(target="isPrivateHome", source = "isPrivateHome")
    @Mapping(target="corpus", source = "corpus")
    @Mapping(target="entrance", source = "entrance")
    @Mapping(target="floor", source = "floor")
    @Mapping(target="apartment", source = "apartment")
    AddressDto mapAddress(Address address);

}
