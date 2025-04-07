package com.restaurant.client.deliveryservice.domain;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table
@Data
public class Street {

    @Id
    @SequenceGenerator(name = "street_sequence", sequenceName = "street_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "street_sequence")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Locality locality;

}
