package com.iitposs.pos.controller;

import com.iitposs.pos.dto.request.OrderSaveRequestDTO;
import com.iitposs.pos.entity.Orders;
import com.iitposs.pos.service.OrderService;
import com.iitposs.pos.util.enums.StandardResponse;
import org.aspectj.weaver.StandardAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save-order")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody OrderSaveRequestDTO saveRequestDTO) {

        String data = orderService.saveOrder(saveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Success",data), HttpStatus.CREATED
        );

    }

}
