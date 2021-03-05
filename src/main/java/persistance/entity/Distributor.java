package persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Distributor {

    @Id
    private int distributorId;

    @Column
    private String distributorName;

    @Column
    private String noPhone;

    @Column
    private String address;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
}
