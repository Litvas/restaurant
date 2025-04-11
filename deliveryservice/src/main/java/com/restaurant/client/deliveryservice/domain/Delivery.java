package com.restaurant.client.deliveryservice.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Delivery {

    @Id
    @SequenceGenerator(name = "delivery_sequence", sequenceName = "delivery_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_sequence")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


}
