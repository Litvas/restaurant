package com.restaurant.client.deliveryservice.dto;


import lombok.Data;

@Data
public class AddressDto {

    private String localityName;
    private String streetName;
    private String number;
    private Boolean isPrivateHome;
    private String corpus;
    private String entrance;
    private String floor;
    private String apartment;

}