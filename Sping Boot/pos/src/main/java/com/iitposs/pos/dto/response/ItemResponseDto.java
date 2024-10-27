package com.iitposs.pos.dto.response;

import com.iitposs.pos.util.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDto {

    private String itemName;

    private MeasuringType measuringType;

    private double supplierPrice;

    private double displayPrice;

    private double sellingPrice;

    private int qtyOnHand;

    private boolean activeState;

}
