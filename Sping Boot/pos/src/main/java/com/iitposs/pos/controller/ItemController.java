package com.iitposs.pos.controller;

import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemResponseDto;
import com.iitposs.pos.entity.Item;
import com.iitposs.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save-item")
    public String saveItem(@RequestBody ItemSaveRequestDTO saveRequestDTO) {

        return itemService.saveItem(saveRequestDTO);

    }

    @PutMapping("/update-item")
    public String updateItem(@RequestBody ItemSaveRequestDTO requestDTO) {

        return itemService.updateItem(requestDTO);
    }

    @GetMapping("/get-all-items")
    public List<ItemResponseDto> getAllItems() {
        List<ItemResponseDto> dtoList = itemService.getAllItems();

        return dtoList;
    }

    @GetMapping(
            path = "/get-item-by-id",
            params = "id"
    )
    public ItemResponseDto getItemById(@RequestParam(value = "id") int itemId) {
        return itemService.getItemsById(itemId);
    }

    @DeleteMapping(
            path = "/delete-item/{id}"
    )
    public String deleteItem(@PathVariable(value = "id") int itemId) {
        return itemService.deleteItem(itemId);
    }

}
