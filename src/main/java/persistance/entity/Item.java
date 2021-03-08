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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_type_code", referencedColumnName = "item_type_code")
    private ItemType itemType;

    @OneToMany(mappedBy = "item")
    private List<Distributor> distributor;
}
