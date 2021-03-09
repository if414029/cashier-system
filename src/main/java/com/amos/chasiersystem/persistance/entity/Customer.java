package com.amos.chasiersystem.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column
    private String customerName;

    @Column
    private String gender;

    @Column
    private String phoneNo;

    @Column
    private String address;

}
