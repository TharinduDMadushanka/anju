package com.iitposs.pos.service.impl;

import com.iitposs.pos.dto.request.CustomerSaveRequestDTO;
import com.iitposs.pos.dto.response.CustomerAllDetailsResponseDto;
import com.iitposs.pos.dto.response.CustomerResponseDto;
import com.iitposs.pos.entity.Customer;
import com.iitposs.pos.exception.NotFoundException;
import com.iitposs.pos.repo.CustomerRepo;
import com.iitposs.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerSaveRequestDTO saveRequestDTO) {

        Customer customer = new Customer(
                saveRequestDTO.getCustomerId(),
                saveRequestDTO.getCustomerName(),
                saveRequestDTO.getCustomerAddress(),
                saveRequestDTO.getSalary(),
                saveRequestDTO.getContacts(),
                saveRequestDTO.getNic(),
                saveRequestDTO.isActiveState()
        );

        customerRepo.save(customer);
        return "Customer saved successfully";
    }

    @Override
    public String updateCustomer(CustomerSaveRequestDTO requestDTO) {

        if (customerRepo.existsById(requestDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(requestDTO.getCustomerId());

            customer.setCustomerName(requestDTO.getCustomerName());
            customer.setCustomerAddress(requestDTO.getCustomerAddress());
            customer.setSalary(requestDTO.getSalary());
            customer.setActiveState(requestDTO.isActiveState());

            customerRepo.save(customer);
            return requestDTO.getCustomerName()+ " updated successfully";
        }else {
            return "Customer not found";
        }

    }

    @Override
    public CustomerResponseDto getCustomerById(int customerId) {

        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);

//            CustomerResponseDto responseDto = new CustomerResponseDto(
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getSalary(),
//                    customer.getContacts(),
//                    customer.getNic(),
//                    customer.isActiveState()
//            );
//
//            return responseDto;

            return new CustomerResponseDto(
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getSalary(),
                    customer.getContacts(),
                    customer.getNic(),
                    customer.isActiveState()
            );

        }else {
            return null;
        }
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();

        List<CustomerResponseDto> responseDtoList = new ArrayList<>();

        if (!customers.isEmpty()) {
            for (Customer customer : customers) {
                responseDtoList.add(new CustomerResponseDto(
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getSalary(),
                        customer.getContacts(),
                        customer.getNic(),
                        customer.isActiveState()
                ));
            }
            return responseDtoList;
        }else {
            throw new NotFoundException("Customer not found..!");
        }
    }

    @Override
    public String deleteCustomer(int customerId) {

        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return customerId+ " deleted successfully";
        }else {
            return "Customer not found";
        }
    }

    @Override
    public List<CustomerAllDetailsResponseDto> getAlCustomersByState(boolean state) {

        List<Customer> customers = customerRepo.findAllByActiveStateEquals(state);

        List<CustomerAllDetailsResponseDto> responseDtoList = new ArrayList<>();

        for (Customer customer : customers) {
            responseDtoList.add(new CustomerAllDetailsResponseDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getSalary(),
                    customer.getContacts(),
                    customer.getNic(),
                    customer.isActiveState()
            ));
        }
        return responseDtoList;

    }
}
