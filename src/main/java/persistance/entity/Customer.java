package persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer {

    @Id
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
