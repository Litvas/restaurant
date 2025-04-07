package com.restaurant.client.deliveryservice.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Locality {

    @Id
    @SequenceGenerator(name = "locality_sequence", sequenceName = "locality_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locality_sequence")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private LocalityType localityType;

    @OneToMany(mappedBy = "locality", fetch = FetchType.LAZY)
    List<Street> streetList;

}
