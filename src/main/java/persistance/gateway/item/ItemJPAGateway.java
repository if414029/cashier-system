package persistance.gateway.item;

import persistance.entity.Item;

import java.util.List;

public class ItemJPAGateway implements ItemGateway{
    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public Item findItemById(int itemId) {
        return null;
    }

    @Override
    public void createItem(Item item) {

    }
}
