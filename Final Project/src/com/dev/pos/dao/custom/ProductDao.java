package com.dev.pos.dao.custom;

import com.dev.pos.dao.CrudDao;
import com.dev.pos.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao extends CrudDao<Product, Integer> {

    //    public boolean saveProduct(Product product) throws SQLException, ClassNotFoundException;
//    public boolean updateProduct(Product product) throws SQLException, ClassNotFoundException;
//    public boolean deleteProduct(int code) throws SQLException, ClassNotFoundException;
//    public Product findProduct(int code) throws SQLException, ClassNotFoundException;
//    public List<Product> findAllProduct() throws SQLException, ClassNotFoundException;
//    public List<Product> searchProduct(String value) throws SQLException, ClassNotFoundException;
    public int getLastProductId() throws SQLException, ClassNotFoundException;

    public List<Product> searchByDescription(String value) throws SQLException, ClassNotFoundException;
}
