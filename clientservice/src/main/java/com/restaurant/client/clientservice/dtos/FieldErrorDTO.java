package com.restaurant.client.clientservice.dtos;

import lombok.Data;

@Data
public class FieldErrorDTO {

    private String fieldName;
    private String errorMessage;

}
