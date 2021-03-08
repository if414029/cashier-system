package service.item;

import common.InvalidRequestException;
import common.NotFoundException;
import persistance.gateway.item.ItemGateway;
import service.entity.ItemListResponse;
import service.entity.ItemRequest;
import service.entity.CustomerRequest;
import service.entity.ItemResponse;

public class ItemService implements Item {

    private final ItemGateway gateway;

    public ItemService(ItemGateway gateway) {
        this.gateway = gateway;
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
    public void createItem(ItemRequest request) throws InvalidRequestException {
        validateRequest(request);
        gateway.createItem(request);
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
