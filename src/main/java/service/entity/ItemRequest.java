package service.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequest {
    private String itemName;
    private double price;
    private int stock;
    private String itemTypeCode;
    private int distributorId;
}
