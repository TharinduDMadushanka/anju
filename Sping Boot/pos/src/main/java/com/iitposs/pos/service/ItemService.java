package com.iitposs.pos.service;

import com.iitposs.pos.dto.request.ItemSaveRequestDTO;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO saveRequestDTO);
}
