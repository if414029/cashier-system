package service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

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
