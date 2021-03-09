package com.amos.chasiersystem.service.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerListResponse extends ServiceResponse{
    private List<CustomerResponse> listCustomer;
}
