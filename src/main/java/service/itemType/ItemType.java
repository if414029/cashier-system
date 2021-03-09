package service.itemType;

import common.InvalidRequestException;
import common.NotFoundException;
import service.entity.*;

public interface ItemType {
    ItemTypeListResponse findAll();

    ItemTypeResponse findItemTypeByItemTypeCode(String itemTypeCode) throws InvalidRequestException, NotFoundException;

    void createItemType(ItemTypeRequest request);
}
