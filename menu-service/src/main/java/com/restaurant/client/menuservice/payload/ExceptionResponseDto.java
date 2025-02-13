package com.restaurant.client.menuservice.payload;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ExceptionResponseDto {
    private String code;
    private String status;
    private String message;
}
