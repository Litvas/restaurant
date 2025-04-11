package com.restaurant.client.deliveryservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Locality locality;

    @ManyToOne(cascade = CascadeType.ALL)
    private Street street;

    @NotBlank
    @Column(nullable = false)
    private String number;

    @ColumnDefault("true")
    private Boolean isPrivateHome;

    private String corpus;

    private String entrance;

    private String floor;

    private String apartment;

}
