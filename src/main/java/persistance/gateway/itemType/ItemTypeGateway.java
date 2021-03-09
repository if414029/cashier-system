package persistance.gateway.itemType;

import common.NotFoundException;
import service.entity.ItemRequest;
import service.entity.ItemTypeListResponse;
import service.entity.ItemTypeRequest;
import service.entity.ItemTypeResponse;


public interface ItemTypeGateway {
    ItemTypeListResponse findAll();

    ItemTypeResponse findItemTypeByItemTypeCode(String itemTypeCode) throws NotFoundException;

    void createItemType(ItemTypeRequest request);
}
