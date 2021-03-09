package service.item;

import common.InvalidRequestException;
import common.NotFoundException;
import persistance.gateway.distributor.DistributorGateway;
import persistance.gateway.item.ItemGateway;
import persistance.gateway.itemType.ItemTypeGateway;
import service.entity.*;

public class ItemService implements Item {

    private final ItemGateway gateway;
    private final ItemTypeGateway itemTypeGateway;
    private final DistributorGateway distributorGateway;

    public ItemService(ItemGateway gateway, ItemTypeGateway itemTypeGateway, DistributorGateway distributorGateway) {
        this.gateway = gateway;
        this.itemTypeGateway = itemTypeGateway;
        this.distributorGateway = distributorGateway;
    }

    @Override
    public ItemListResponse findAll() {
        return gateway.findAll();
    }

    @Override
    public ItemResponse findItemById(int itemId) throws InvalidRequestException, NotFoundException {
        validateRequestId(itemId);
        return gateway.findItemById(itemId);
    }

    @Override
    public void createItem(ItemRequest request) throws InvalidRequestException, NotFoundException {
        validateRequest(request);
        setItemTypeCodeAndDistributorRequest(request);
        gateway.createItem(request);
    }

    private void setItemTypeCodeAndDistributorRequest(ItemRequest request) throws NotFoundException {
        ItemTypeResponse itemTypeCode = itemTypeGateway.findItemTypeByItemTypeCode(request.getItemTypeCode());
        request.setItemTypeCode(itemTypeCode.getItemTypeCode());

        DistributorResponse distributor = distributorGateway.findDistributorById(request.getDistributorId());
        request.setDistributorId(distributor.getDistributorId());
    }

    private void validateRequestId(int itemId) throws InvalidRequestException {
        if (itemId < 0) {
            throw new InvalidRequestException("Id can't be lower than 0");
        }
    }

    private void validateRequest(ItemRequest request) throws InvalidRequestException {
        if (request == null) {
            throw new InvalidRequestException("Request can't be null!");
        }

        if (request.getItemName() == null) {
            throw new InvalidRequestException("Item Name can't be null!");
        }

        if (request.getItemTypeCode() == null) {
            throw new InvalidRequestException("Item Type Code can't be null!");
        }

        if (request.getStock() < 0) {
            throw new InvalidRequestException("Stock can't be lower than 0!");
        }

    }

}
