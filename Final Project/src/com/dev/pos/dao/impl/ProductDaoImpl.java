package com.dev.pos.dao.impl;

import com.dev.pos.dao.custom.ProductDao;
import com.dev.pos.entity.Product;

import java.util.Collections;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean saveProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int code) {
        return false;
    }

    @Override
    public Product findProduct(int code) {
        return null;
    }

    @Override
    public List<Product> findAllProduct() {
        return Collections.emptyList();
    }

    @Override
    public List<Product> searchProduct(String value) {
        return Collections.emptyList();
    }

    @Override
    public int getLastProductId() {
        return 0;
    }
}