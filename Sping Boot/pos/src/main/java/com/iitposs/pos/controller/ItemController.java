package com.iitposs.pos.controller;

import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemResponseDto;
import com.iitposs.pos.entity.Item;
import com.iitposs.pos.service.ItemService;
import com.iitposs.pos.util.enums.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save-item")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO saveRequestDTO) {

        String message = itemService.saveItem(saveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",message), HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemByName(@RequestParam(value = "name") String name) {

        List<ItemResponseDto> responseDtos = itemService.getItemByName(name);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",responseDtos), HttpStatus.CREATED
        );

    }

//    @PutMapping("/update-item")
//    public String updateItem(@RequestBody ItemSaveRequestDTO requestDTO) {
//
//        return itemService.updateItem(requestDTO);
//    }
//
//    @GetMapping("/get-all-items")
//    public List<ItemResponseDto> getAllItems() {
//        List<ItemResponseDto> dtoList = itemService.getAllItems();
//
//        return dtoList;
//    }
//
//    @GetMapping(
//            path = "/get-item-by-id",
//            params = "id"
//    )
//    public ItemResponseDto getItemById(@RequestParam(value = "id") int itemId) {
//        return itemService.getItemsById(itemId);
//    }
//
//    @DeleteMapping(
//            path = "/delete-item/{id}"
//    )
//    public String deleteItem(@PathVariable(value = "id") int itemId) {
//        return itemService.deleteItem(itemId);
//    }

}
