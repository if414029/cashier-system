package com.amos.chasiersystem.service.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistributorResponse extends ServiceResponse {
    private int distributorId;
    private String distributorName;
    private String noPhone;
    private String address;
}
