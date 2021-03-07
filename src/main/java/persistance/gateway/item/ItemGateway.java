package persistance.gateway.item;

import persistance.entity.Item;

import java.util.List;

public interface ItemGateway {
    List<Item> findAll();

    Item findItemById(int itemId);

    void createItem(Item item);
}
