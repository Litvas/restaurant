package com.restaurant.client.deliveryservice.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Locality {

    @Id
    @SequenceGenerator(name = "locality_sequence", sequenceName = "locality_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locality_sequence")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(50) default 'CITY'")
    private LocalityType localityType = LocalityType.CITY;

    @OneToMany(mappedBy = "locality", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Street> streetList;

}
