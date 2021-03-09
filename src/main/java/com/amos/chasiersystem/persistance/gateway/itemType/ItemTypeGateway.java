package com.amos.chasiersystem.persistance.gateway.itemType;

import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.service.entity.ItemTypeListResponse;
import com.amos.chasiersystem.service.entity.ItemTypeRequest;
import com.amos.chasiersystem.service.entity.ItemTypeResponse;


public interface ItemTypeGateway {
    ItemTypeListResponse findAll();

    ItemTypeResponse findItemTypeByItemTypeCode(String itemTypeCode) throws NotFoundException;

    void createItemType(ItemTypeRequest request);
}
