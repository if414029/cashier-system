package com.amos.chasiersystem.service.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemListResponse extends ServiceResponse{
    private List<ItemResponse> listItem;
}
