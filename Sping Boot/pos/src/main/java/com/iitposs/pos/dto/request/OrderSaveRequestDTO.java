package com.iitposs.pos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderSaveRequestDTO {

    private int customerId;
    private Date date;
    private double total;
    private List<OrderDetailsSavRequestDTO> saveRequestDTOList;

}
