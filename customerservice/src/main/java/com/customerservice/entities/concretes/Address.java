package com.customerservice.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "street",nullable = false)
    private String street;

    @Column(name = "flatNumber",nullable = false)
    private String flatNumber;

    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "defaultAddress",nullable = false)
    private boolean defaultAddress;

    @ManyToOne()
    @JoinColumn(name = "district_id",nullable = false)
    private District district;

    @ManyToOne()
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
}
