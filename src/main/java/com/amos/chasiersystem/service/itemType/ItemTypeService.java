package com.amos.chasiersystem.service.itemType;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import org.springframework.stereotype.Service;
import com.amos.chasiersystem.persistance.gateway.itemType.ItemTypeGateway;
import com.amos.chasiersystem.service.entity.ItemTypeListResponse;
import com.amos.chasiersystem.service.entity.ItemTypeRequest;
import com.amos.chasiersystem.service.entity.ItemTypeResponse;

@Service
public class ItemTypeService implements ItemType{

    private final ItemTypeGateway gateway;

    public ItemTypeService(ItemTypeGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public ItemTypeListResponse findAll() {
        return gateway.findAll();
    }

    @Override
    public ItemTypeResponse findItemTypeByItemTypeCode(String itemTypeCode) throws InvalidRequestException, NotFoundException {
        validateRequestItemTypeCode(itemTypeCode);
        return gateway.findItemTypeByItemTypeCode(itemTypeCode);
    }

    @Override
    public void createItemType(ItemTypeRequest request) {
        gateway.createItemType(request);
    }

    private void validateRequestItemTypeCode(String itemTypeCode) throws InvalidRequestException {
        if (itemTypeCode == null) {
            throw new InvalidRequestException("Item Type Code can't be null");
        }
    }
}
