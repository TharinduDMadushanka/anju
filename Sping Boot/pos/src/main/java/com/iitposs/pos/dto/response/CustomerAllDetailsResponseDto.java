package com.iitposs.pos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAllDetailsResponseDto {

    private int customerId;

    private String customerName;

    private String customerAddress;

    private double salary;

    private ArrayList contacts;

    private String nic;

    private boolean activeState;

}
