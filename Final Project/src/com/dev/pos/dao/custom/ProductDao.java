package com.dev.pos.dao.custom;

import com.dev.pos.entity.Product;

import java.util.List;

public interface ProductDao {

    public boolean saveProduct(Product product);
    public boolean updateProduct(Product product);
    public boolean deleteProduct(int code);
    public Product findProduct(int code);
    public List<Product> findAllProduct();
    public List<Product> searchProduct(String value);
    public int getLastProductId();
}
