package persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class ItemType {

    @Id
    private String itemTypeCode;

    @Column
    private String itemTypeName;

}
