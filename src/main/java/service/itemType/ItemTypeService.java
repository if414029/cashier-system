package service.itemType;

import common.InvalidRequestException;
import common.NotFoundException;
import persistance.gateway.itemType.ItemTypeGateway;
import service.entity.ItemRequest;
import service.entity.ItemTypeListResponse;
import service.entity.ItemTypeRequest;
import service.entity.ItemTypeResponse;

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
