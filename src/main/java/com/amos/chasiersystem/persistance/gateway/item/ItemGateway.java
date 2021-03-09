package com.amos.chasiersystem.persistance.gateway.item;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.service.entity.ItemListResponse;
import com.amos.chasiersystem.service.entity.ItemRequest;
import com.amos.chasiersystem.service.entity.ItemResponse;

public interface ItemGateway {
    ItemListResponse findAll();

    ItemResponse findItemById(int itemId) throws NotFoundException, InvalidRequestException;

    void createItem(ItemRequest item);

    void updateItem(int itemId, int stock);
}
