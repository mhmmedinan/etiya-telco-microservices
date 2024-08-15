package com.customerservice.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "individualCustomer")
@PrimaryKeyJoinColumn(name = "customer_id")
public class IndividualCustomer extends Customer {

    @Column(name = "firstName",nullable = false,length = 50)
    private String firstName;

    @Column(name = "middleName",nullable = false,length = 50)
    private String middleName;

    @Column(name = "lastName",nullable = false,length = 50)
    private String lastName;

    @Column(name = "nationalityId",nullable = false,unique = true,updatable = false,length = 11)
    private String nationalityId;

    @Column(name = "birthDate",nullable = false)
    private String birthDate;

    @Column(name = "motherName",nullable = false,length = 50)
    private String motherName;

    @Column(name = "fatherName",nullable = false,length = 50)
    private String fatherName;

    @Column(name = "gender",nullable = false,length = 50)
    private String gender;


}
