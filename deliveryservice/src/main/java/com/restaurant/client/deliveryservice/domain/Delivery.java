package com.restaurant.client.deliveryservice.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Delivery {

    @Id
    @SequenceGenerator(name = "delivery_sequence", sequenceName = "delivery_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_sequence")
    private Long id;

    @OneToOne
    private Address address;


}
