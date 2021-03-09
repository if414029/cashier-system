package controller;

import common.InvalidRequestException;
import common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.entity.*;
import service.itemType.ItemType;

@RestController
@RequestMapping("/api/v1/itemTypes")
public class ItemTypeController {
    @Autowired
    private ItemType itemType;

    @GetMapping(path = "/")
    private ResponseEntity<Object> findAll() {
        ItemTypeListResponse response =  itemType.findAll();

        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage(HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{itemTypeCode}")
    public ResponseEntity<Object> findItemTypeByItemTypeCode(@PathVariable String itemTypeCode) throws NotFoundException, InvalidRequestException {
        ItemTypeResponse response = itemType.findItemTypeByItemTypeCode(itemTypeCode);

        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage(HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    @PostMapping("/")
    public ResponseEntity<Object> createItemType(@RequestBody ItemTypeRequest request) throws InvalidRequestException, NotFoundException {
        ServiceResponse response = new ServiceResponse();

        itemType.createItemType(request);

        response.setStatusCode(HttpStatus.CREATED.value());
        response.setStatusMessage(HttpStatus.CREATED.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
}
