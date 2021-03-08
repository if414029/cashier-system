package persistance.gateway.item;

import common.InvalidRequestException;
import common.NotFoundException;
import service.entity.ItemListResponse;
import service.entity.ItemRequest;
import service.entity.ItemResponse;

import java.util.List;

public interface ItemGateway {
    ItemListResponse findAll();

    ItemResponse findItemById(int itemId) throws NotFoundException, InvalidRequestException;

    void createItem(ItemRequest item);
}
