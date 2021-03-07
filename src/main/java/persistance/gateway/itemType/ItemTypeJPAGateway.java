package persistance.gateway.itemType;

import persistance.entity.ItemType;

import java.util.List;

public class ItemTypeJPAGateway implements ItemTypeGateway{
    @Override
    public List<ItemType> findAll() {
        return null;
    }

    @Override
    public ItemType findItemTypeByCode(String itemTypeCode) {
        return null;
    }

    @Override
    public void createItem(ItemType itemType) {

    }
}
