package com.restaurant.client.clientservice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Data
public class ClientDTO {

    private String innerId;
    private String phone;
    private String username;
    private Long bonuses;
    private LocalDateTime createdDate;

}
