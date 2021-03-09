package persistance.gateway.itemType;

import common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import persistance.entity.ItemType;
import persistance.repository.ItemTypeRepository;
import service.entity.*;

import java.util.ArrayList;
import java.util.List;

public class ItemTypeJPAGateway implements ItemTypeGateway{

    @Autowired
    private ItemTypeRepository repository;

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
