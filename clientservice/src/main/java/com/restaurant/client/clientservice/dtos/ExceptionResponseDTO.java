package com.restaurant.client.clientservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO {
    private String code;
    private String status;
    private String message;
}
