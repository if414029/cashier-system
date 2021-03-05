package persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
public class Transaction {
    @Id
    private int transactionId;

    @Column
    private String itemId;

    @ManyToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private Customer customer;

    @Column
    private Date purchaseDate;

    @Column
    private String description;

    @Column
    private double totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_type_code", referencedColumnName = "payment_type_code")
    private PaymentType paymentTypeCode;
}
