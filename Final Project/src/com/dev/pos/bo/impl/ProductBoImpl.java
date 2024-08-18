package com.dev.pos.bo.impl;

import com.dev.pos.bo.custom.ProductBo;
import com.dev.pos.dto.ProductDto;
import com.dev.pos.entity.Product;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProductBoImpl implements ProductBo {
    @Override
    public boolean saveProduct(ProductDto productDto) throws SQLException, ClassNotFoundException {
        return productDao.save(new Product(
                productDto.getCode(),
                productDto.getDescription()
        ));
    }

    @Override
    public boolean updateProduct(ProductDto productDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteProduct(int code) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ProductDto findProduct(int code) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<ProductDto> findAllProduct() throws SQLException, ClassNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public List<ProductDto> searchProduct(String value) throws SQLException, ClassNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public int getLastProductId() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public List<ProductDto> searchByDescription(String value) throws SQLException, ClassNotFoundException {
        return Collections.emptyList();
    }
}
