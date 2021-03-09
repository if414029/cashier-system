package com.amos.chasiersystem.service.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransactionListResponse extends ServiceResponse {
    private List<TransactionResponse> listTransaction;
}
