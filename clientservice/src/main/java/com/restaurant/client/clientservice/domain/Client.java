package com.restaurant.client.clientservice.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
public class Client {

    @Id
    @SequenceGenerator(name = "client_sequence", sequenceName = "client_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_sequence")
    private Long id;

    @UuidGenerator
    private String innerId;

    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$")
    private String phone;

    @NotBlank
    private String username;

    private Long bonuses;

    private LocalDateTime createdDate = LocalDateTime.now();

}
