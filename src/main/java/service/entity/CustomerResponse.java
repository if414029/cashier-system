package service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class CustomerResponse extends ServiceResponse {
    private int customerId;
    private String customerName;
    private String gender;
    private String phoneNo;
    private String address;
}

