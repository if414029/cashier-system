package com.amos.chasiersystem.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column
    private String itemName;

    @Column
    private double price;

    @Column
    private int stock;

    @Column
    private String itemTypeCode;

    @Column
    private int distributorId;
}
