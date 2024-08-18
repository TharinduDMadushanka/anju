package com.dev.pos.bo.impl;

import com.dev.pos.Enum.DaoType;
import com.dev.pos.bo.custom.CustomerBo;
import com.dev.pos.dao.DaoFactory;
import com.dev.pos.dao.custom.CustomerDao;
import com.dev.pos.dto.CustomerDTO;
import com.dev.pos.entity.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoType.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDao.save(new Customer(
                customerDTO.getEmail(),
                customerDTO.getName(),
                customerDTO.getContact(),
                customerDTO.getSalary()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerDao.update(new Customer(
                customerDTO.getEmail(),
                customerDTO.getName(),
                customerDTO.getContact(),
                customerDTO.getSalary()
        ));
    }

    @Override
    public boolean deleteCustomer(String email) throws Exception {
        return customerDao.delete(email);
    }

    @Override
    public CustomerDTO findCustomer(String email) throws Exception {
        Customer customer = customerDao.find(email);
        if (customer != null) {
            return new CustomerDTO(
                    customer.getEmail(),
                    customer.getName(),
                    customer.getContact(),
                    customer.getSalary()
            );
        }
        return null;
    }

    @Override
    public List<CustomerDTO> searchCustomer(String value) throws Exception {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer c : customerDao.search(value)) {
            customerDTOList.add(new CustomerDTO(
                    c.getEmail(),
                    c.getName(),
                    c.getContact(),
                    c.getSalary()
            ));
        }
        return customerDTOList;
    }

    @Override
    public List<CustomerDTO> findAllCustomer() throws Exception {
        List<Customer> allCustomers = customerDao.findAll();
        List<CustomerDTO> customerDTOs = new ArrayList<>();
        for (Customer c : allCustomers) {
            customerDTOs.add(new CustomerDTO(
                    c.getEmail(),
                    c.getName(),
                    c.getContact(),
                    c.getSalary()
            ));
        }
        return customerDTOs;
    }
}
