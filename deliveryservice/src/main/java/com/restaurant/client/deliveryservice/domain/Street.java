package com.restaurant.client.deliveryservice.domain;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table
@Data
public class Street {

    @Id
    @SequenceGenerator(name = "street_sequence", sequenceName = "street_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "street_sequence")
    private Long id;

//    fix it
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Locality locality;

}
