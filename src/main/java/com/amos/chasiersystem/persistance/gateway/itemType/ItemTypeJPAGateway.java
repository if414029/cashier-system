package com.amos.chasiersystem.persistance.gateway.itemType;

import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.persistance.entity.ItemType;
import com.amos.chasiersystem.persistance.repository.ItemTypeRepository;
import com.amos.chasiersystem.service.entity.*;

import java.util.ArrayList;
import java.util.List;

public class ItemTypeJPAGateway implements ItemTypeGateway{

    private final ItemTypeRepository repository;

    public ItemTypeJPAGateway(ItemTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ItemTypeListResponse findAll() {
        List<ItemType> itemTypeList = repository.findAll();
        return constructItemTypeListResponse(itemTypeList);
    }

    @Override
    public ItemTypeResponse findItemTypeByItemTypeCode(String itemTypeCode) throws NotFoundException {
        return repository.findById(itemTypeCode)
                .map(this::constructItemTypeResponse)
                .orElseThrow(() -> new NotFoundException("Data Not Found with id : " + itemTypeCode));
    }

    @Override
    public void createItemType(ItemTypeRequest request) {
        ItemType entity = getItemTypeEntity(request);
        repository.save(entity);
    }

    private ItemTypeListResponse constructItemTypeListResponse(List<ItemType> itemTypeList) {
        ItemTypeListResponse itemTypeListResponse = new ItemTypeListResponse();

        List<ItemTypeResponse> itemTypeResponses = new ArrayList<>();
        for (ItemType itemType : itemTypeList){
            itemTypeResponses.add(constructItemTypeResponse(itemType));
        }

        itemTypeListResponse.setListItemType(itemTypeResponses);

        return itemTypeListResponse;
    }

    private ItemType getItemTypeEntity(ItemTypeRequest request) {
        ItemType entity = new ItemType();
        entity.setItemTypeCode(request.getItemTypeCode());
        entity.setItemTypeName(request.getItemTypeName());

        return entity;
    }

    private ItemTypeResponse constructItemTypeResponse(ItemType itemType){
        ItemTypeResponse response = new ItemTypeResponse();
        response.setItemTypeCode(itemType.getItemTypeCode());
        response.setItemTypeName(itemType.getItemTypeName());

        return response;
    }
}
