package persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Item {
    @Id
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
