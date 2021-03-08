package service.item;

import common.InvalidRequestException;
import common.NotFoundException;
import service.entity.*;

public interface Item {
    ItemListResponse findAll();

    ItemResponse findItemById(int itemId) throws InvalidRequestException, NotFoundException;

    void createItem(ItemRequest request) throws InvalidRequestException;
}
