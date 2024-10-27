package com.iitposs.pos.controller;

import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
