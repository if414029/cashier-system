package com.amos.chasiersystem.service.itemType;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.service.entity.*;

public interface ItemType {
    ItemTypeListResponse findAll();

    ItemTypeResponse findItemTypeByItemTypeCode(String itemTypeCode) throws InvalidRequestException, NotFoundException;

    void createItemType(ItemTypeRequest request);
}
