package com.iitposs.pos.service.impl;

import com.iitposs.pos.dto.paginated.PaginatedResponseItemDTO;
import com.iitposs.pos.dto.request.ItemSaveRequestDTO;
import com.iitposs.pos.dto.response.ItemResponseDto;
import com.iitposs.pos.entity.Item;
import com.iitposs.pos.repo.ItemRepo;
import com.iitposs.pos.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO saveRequestDTO) {

//        Item item = new Item(
//                saveRequestDTO.getItemName(),
//                saveRequestDTO.getMeasuringType(),
//                saveRequestDTO.getSupplierPrice(),
//                saveRequestDTO.getDisplayPrice(),
//                saveRequestDTO.getSellingPrice(),
//                saveRequestDTO.getQtyOnHand(),
//                saveRequestDTO.isActiveState()
//        );

        Item item = modelMapper.map(saveRequestDTO, Item.class);

        if (!itemRepo.existsById(item.getItemID())){
            itemRepo.save(item);
            return "Item Saved";
        }else {
            return "Item Already Exists";
        }
    }

    @Override
    public List<ItemResponseDto> getItemByName(String name) {

        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(name, true);

        if (!items.isEmpty()){
            List<ItemResponseDto> itemResponseDtos = modelMapper.map(
                    items, new TypeToken<List<ItemResponseDto>>() {}.getType()
            );
            return itemResponseDtos;
        }else {
            return null;
        }

    }

    @Override
    public PaginatedResponseItemDTO getItemByState(boolean state, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(state, PageRequest.of(page, size));

        if (!items.isEmpty()){
            List<ItemResponseDto> itemResponseDtos =
                    modelMapper.map(items.getContent(), new TypeToken<List<ItemResponseDto>>() {}.getType());

            return new PaginatedResponseItemDTO(
                    itemResponseDtos,
                    items.getTotalElements()
            );

        }else {
            throw new NoSuchElementException("No data found");
        }

    }

//    @Override
//    public String updateItem(ItemSaveRequestDTO requestDTO) {
//
//        if (itemRepo.existsById(requestDTO.getItemID())) {
//            Item item = itemRepo.getReferenceById(requestDTO.getItemID());
//
//            item.setItemName(requestDTO.getItemName());
//            item.setMeasuringType(requestDTO.getMeasuringType());
//            item.setSupplierPrice(requestDTO.getSupplierPrice());
//            item.setDisplayPrice(requestDTO.getDisplayPrice());
//            item.setSellingPrice(requestDTO.getSellingPrice());
//            item.setQtyOnHand(requestDTO.getQtyOnHand());
//            item.setActiveState(requestDTO.isActiveState());
//
//            itemRepo.save(item);
//            return "Item Updated";
//        }else {
//            return "Item Not Found";
//        }
//    }
//
//    @Override
//    public List<ItemResponseDto> getAllItems() {
//        List<Item> items = itemRepo.findAll();
//        List<ItemResponseDto> itemResponseDtos = new ArrayList<>();
//
//        for (Item item : items) {
//            itemResponseDtos.add(new ItemResponseDto(
//                    item.getItemName(),
//                    item.getMeasuringType(),
//                    item.getSupplierPrice(),
//                    item.getDisplayPrice(),
//                    item.getSellingPrice(),
//                    item.getQtyOnHand(),
//                    item.isActiveState()
//            ));
//        }
//        return itemResponseDtos;
//    }
//
//    @Override
//    public ItemResponseDto getItemsById(int itemId) {
//
//        if (itemRepo.existsById(itemId)) {
//            Item item = itemRepo.getReferenceById(itemId);
//
//            return new ItemResponseDto(
//                    item.getItemName(),
//                    item.getMeasuringType(),
//                    item.getSupplierPrice(),
//                    item.getDisplayPrice(),
//                    item.getSellingPrice(),
//                    item.getQtyOnHand(),
//                    item.isActiveState()
//            );
//        }else {
//            return null;
//        }
//    }
//
//    @Override
//    public String deleteItem(int itemId) {
//
//        if (itemRepo.existsById(itemId)) {
//            itemRepo.deleteById(itemId);
//            return itemId+ " Item Deleted";
//        }else {
//            return "Item Not Found";
//        }
//    }

}
