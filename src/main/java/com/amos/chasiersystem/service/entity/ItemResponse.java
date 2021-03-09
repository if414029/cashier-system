package com.amos.chasiersystem.service.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponse extends ServiceResponse {

    private int itemId;
    private String itemName;
    private double price;
    private int stock;
    private ItemTypeResponse itemType;
    private DistributorResponse distributor;

}
