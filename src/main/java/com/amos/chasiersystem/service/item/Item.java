package com.amos.chasiersystem.service.item;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.service.entity.*;

public interface Item {
    ItemListResponse findAll();

    ItemResponse findItemById(int itemId) throws InvalidRequestException, NotFoundException;

    void createItem(ItemRequest request) throws InvalidRequestException, NotFoundException;
}
