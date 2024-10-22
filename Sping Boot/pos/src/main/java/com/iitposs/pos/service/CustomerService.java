package com.iitposs.pos.service;

import com.iitposs.pos.dto.request.CustomerSaveRequestDTO;
import com.iitposs.pos.dto.response.CustomerAllDetailsResponseDto;
import com.iitposs.pos.dto.response.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerSaveRequestDTO saveRequestDTO);

    String updateCustomer(CustomerSaveRequestDTO requestDTO);

    CustomerResponseDto getCustomerById(int customerId);

    List<CustomerResponseDto> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerAllDetailsResponseDto> getAlCustomersByState(boolean state);
}
