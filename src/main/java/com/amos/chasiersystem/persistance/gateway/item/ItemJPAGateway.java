package com.amos.chasiersystem.persistance.gateway.item;

import antlr.StringUtils;
import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.persistance.entity.Item;
import com.amos.chasiersystem.persistance.repository.ItemRepository;
import com.amos.chasiersystem.service.entity.ItemListResponse;
import com.amos.chasiersystem.service.entity.ItemRequest;
import com.amos.chasiersystem.service.entity.ItemResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ItemJPAGateway implements ItemGateway{

    private final ItemRepository repository;

    public ItemJPAGateway(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public ItemListResponse findAll() {
        List<Item> itemList = repository.findAll();
        return constructItemListResponse(itemList);
    }

    @Override
    public ItemResponse findItemById(int itemId) throws NotFoundException {
        return repository.findById(itemId)
                .map(this::constructItemResponse)
                .orElseThrow(() -> new NotFoundException("Data Not Found with id : " + itemId));
    }

    @Override
    public void createItem(ItemRequest request) {
        Item entity = getItemEntity(request);

        repository.save(entity);
    }

    @Override
    public void updateItem(int itemId, int stock) {
        repository.updateItemEntity(itemId, stock);
    }

    @Override
    public ItemListResponse findSpesificItem(String itemName, String distributorName) {

        if(!itemName.equalsIgnoreCase(" ")){
            return constructItemListResponse(repository.getItemByItemName(itemName));
        } else if(!distributorName.equalsIgnoreCase(" ")){
            return constructItemListResponse(repository.getItemByDistributorName(distributorName));
        }

        return constructItemListResponse(repository.findAll());
    }

    private ItemListResponse constructItemListResponse(List<Item> itemList) {
        ItemListResponse itemListResponse = new ItemListResponse();

        List<ItemResponse> itemResponses = new ArrayList<>();
        for(Item item : itemList){
            itemResponses.add(constructItemResponse(item));
        }

        itemListResponse.setListItem(itemResponses);

        return itemListResponse;
    }

    private Item getItemEntity(ItemRequest request) {
        Item entity = new Item();
        entity.setItemName(request.getItemName());
        entity.setPrice(request.getPrice());
        entity.setStock(request.getStock());
        entity.setItemTypeCode(request.getItemTypeCode());
        entity.setDistributorId(request.getDistributorId());

        return entity;
    }

    private ItemResponse constructItemResponse(Item item){
        ItemResponse response = new ItemResponse();
        response.setItemId(item.getItemId());
        response.setItemName(item.getItemName());
        response.setPrice(item.getPrice());
        response.setStock(item.getStock());

        return response;
    }
}
