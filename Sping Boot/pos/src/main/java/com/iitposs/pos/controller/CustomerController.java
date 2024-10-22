package com.iitposs.pos.controller;

import com.iitposs.pos.dto.request.CustomerSaveRequestDTO;
import com.iitposs.pos.dto.response.CustomerAllDetailsResponseDto;
import com.iitposs.pos.dto.response.CustomerResponseDto;
import com.iitposs.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save-customer")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO saveRequestDTO) {

        String message = customerService.saveCustomer(saveRequestDTO);
        return message;
    }

    @PutMapping("/update-customer")
    public String updateCustomer(@RequestBody CustomerSaveRequestDTO requestDTO) {

        String message = customerService.updateCustomer(requestDTO);
        return message;
    }

    @GetMapping(
            path = "/get-customer-by-id",
            params = "id"
    )
    public CustomerResponseDto getCustomerById(@RequestParam(value = "id") int customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping(path = "/get-all-customers")
    public List<CustomerResponseDto> getAllCustomers() {
        List<CustomerResponseDto> dtoList = customerService.getAllCustomers();
        return dtoList;
    }

    @DeleteMapping(
            path = "/delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {
        String message = customerService.deleteCustomer(customerId);
        return message;
    }

    @GetMapping(
            path = "/get-all-customer-by-state",
            params = "state"
    )
    public List<CustomerAllDetailsResponseDto> getCustomerByState(@RequestParam(value = "state") boolean state) {
        List<CustomerAllDetailsResponseDto> dtoList = customerService.getAlCustomersByState(state);
        return dtoList;
    }

}
