package persistance.gateway.item;

import common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import persistance.entity.Item;
import persistance.repository.ItemRepository;
import service.entity.ItemListResponse;
import service.entity.ItemRequest;
import service.entity.ItemResponse;

import java.util.ArrayList;
import java.util.List;

public class ItemJPAGateway implements ItemGateway{

    @Autowired
    private ItemRepository repository;

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
