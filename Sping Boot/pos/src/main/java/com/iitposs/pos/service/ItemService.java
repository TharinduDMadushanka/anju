package com.iitposs.pos.service;

import com.iitposs.pos.dto.paginated.PaginatedResponseItemDTO;
import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemResponseDto;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO saveRequestDTO);

    List<ItemResponseDto> getItemByName(String name);

    PaginatedResponseItemDTO getItemByState(boolean state, int page, int size);

//    String updateItem(ItemSaveRequestDTO requestDTO);
//
//    List<ItemResponseDto> getAllItems();
//
//    ItemResponseDto getItemsById(int itemId);
//
//    String deleteItem(int itemId);
}
