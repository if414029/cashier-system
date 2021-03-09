package com.amos.chasiersystem.service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerRequest {
    private String customerName;
    private String gender;
    private String phoneNo;
    private String address;
}
