package com.dev.pos.bo.impl;

import com.dev.pos.Enum.DaoType;
import com.dev.pos.bo.custom.ProductBo;
import com.dev.pos.dao.DaoFactory;
import com.dev.pos.dao.custom.ProductDao;
import com.dev.pos.dto.ProductDto;
import com.dev.pos.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductBoImpl implements ProductBo {

    ProductDao productDao = (ProductDao) DaoFactory.getInstance().getDao(DaoType.PRODUCT);

    @Override
    public boolean saveProduct(ProductDto productDto) throws Exception {
        return productDao.save(new Product(
                productDto.getCode(),
                productDto.getDescription()
        ));
    }

    @Override
    public boolean updateProduct(ProductDto productDto) throws Exception {
        return productDao.update(new Product(
                productDto.getCode(),
                productDto.getDescription()
        ));
    }

    @Override
    public boolean deleteProduct(int code) throws Exception {
        return productDao.delete(code);
    }

    @Override
    public ProductDto findProduct(int code) throws Exception {
        Product product = productDao.find(code);
        if (product != null) {
            return new ProductDto(
                    product.getCode(),
                    product.getDescription()
            );
        }
        return null;
    }

    @Override
    public List<ProductDto> findAllProduct() throws Exception {
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product p : productDao.findAll()) {
            productDtoList.add(new ProductDto(
                    p.getCode(),
                    p.getDescription()
            ));
        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> searchProduct(String value) throws SQLException, ClassNotFoundException {
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product p : productDao.searchByDescription(value)) {
            productDtoList.add(new ProductDto(
                    p.getCode(),
                    p.getDescription()
            ));
        }
        return productDtoList;
    }

    @Override
    public int getLastProductId() throws SQLException, ClassNotFoundException {
        return productDao.getLastProductId();
    }

    @Override
    public List<ProductDto> searchByDescription(String value) throws SQLException, ClassNotFoundException {
        return Collections.emptyList();
    }
}
