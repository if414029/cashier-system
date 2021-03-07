package persistance.gateway.itemType;

import persistance.entity.ItemType;

import java.util.List;

public interface ItemTypeGateway {
    List<ItemType> findAll();

    ItemType findItemTypeByCode(String itemTypeCode);

    void createItem(ItemType itemType);
}
