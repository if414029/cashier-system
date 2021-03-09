package com.amos.chasiersystem.service.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemTypeResponse extends ServiceResponse {
    private String itemTypeCode;
    private String itemTypeName;
}
