package com.iitposs.pos.service;

import com.iitposs.pos.dto.request.OrderSaveRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    String saveOrder(OrderSaveRequestDTO saveRequestDTO);
}
