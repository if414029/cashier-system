package com.amos.chasiersystem.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Distributor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int distributorId;

    @Column
    private String distributorName;

    @Column
    private String noPhone;

    @Column
    private String address;

}
