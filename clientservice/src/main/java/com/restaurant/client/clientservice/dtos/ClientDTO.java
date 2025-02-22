package com.restaurant.client.clientservice.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClientDTO {

    private String innerId;
    private String phone;
    private String username;
    private Long bonuses;
    private LocalDateTime createdDate;

}
