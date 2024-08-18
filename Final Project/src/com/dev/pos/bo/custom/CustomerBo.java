package com.dev.pos.bo.custom;

import com.dev.pos.bo.SuperBo;
import com.dev.pos.dto.CustomerDTO;
import com.dev.pos.entity.Customer;

import java.util.List;

public interface CustomerBo extends SuperBo {

    public boolean saveCustomer(CustomerDTO customerDTO)throws Exception;
    public boolean updateCustomer(CustomerDTO customerDTO)throws Exception;
    public boolean deleteCustomer(String email)throws Exception;
    public CustomerDTO findCustomer(String email)throws Exception;
    public List<CustomerDTO> searchCustomer(String value)throws Exception;
    public List<CustomerDTO> findAllCustomer()throws Exception;

}
