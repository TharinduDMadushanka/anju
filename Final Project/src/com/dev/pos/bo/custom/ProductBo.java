package com.dev.pos.bo.custom;

import com.dev.pos.bo.SuperBo;
import com.dev.pos.dto.ProductDto;
import com.dev.pos.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductBo extends SuperBo {

    public boolean saveProduct(ProductDto productDto) throws Exception;

    public boolean updateProduct(ProductDto productDto) throws Exception;

    public boolean deleteProduct(int code) throws Exception;

    public ProductDto findProduct(int code) throws Exception;

    public List<ProductDto> findAllProduct() throws Exception;

    public List<ProductDto> searchProduct(String value) throws Exception;

    public int getLastProductId() throws Exception;

    public List<ProductDto> searchByDescription(String value) throws Exception;



}
