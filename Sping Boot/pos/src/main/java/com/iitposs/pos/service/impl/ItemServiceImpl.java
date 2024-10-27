package com.iitposs.pos.service.impl;

import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.entity.Item;
import com.iitposs.pos.repo.ItemRepo;
import com.iitposs.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public String saveItem(ItemSaveRequestDTO saveRequestDTO) {

        Item item = new Item(
                saveRequestDTO.getItemID(),
                saveRequestDTO.getItemName(),
                saveRequestDTO.getMeasuringType(),
                saveRequestDTO.getSupplierPrice(),
                saveRequestDTO.getDisplayPrice(),
                saveRequestDTO.getSellingPrice(),
                saveRequestDTO.getQtyOnHand(),
                saveRequestDTO.isActiveState()
        );

        itemRepo.save(item);
        return "Item Saved";

    }

}
