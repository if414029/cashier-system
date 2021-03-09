package service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class DistributorResponse extends ServiceResponse {
    private int distributorId;
    private String distributorName;
    private String noPhone;
    private String address;
}
