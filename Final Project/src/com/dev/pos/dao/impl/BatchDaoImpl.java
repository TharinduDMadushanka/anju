package com.dev.pos.dao.impl;

import com.dev.pos.dao.CrudUtil;
import com.dev.pos.dao.custom.BatchDao;
import com.dev.pos.dto.BatchDTO;
import com.dev.pos.dto.ProductDetailJoinDTO;
import com.dev.pos.entity.Batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BatchDaoImpl implements BatchDao {

    @Override
    public boolean save(Batch batch) throws Exception, ClassNotFoundException {

        String sql = "INSERT INTO batch VALUES (?,?,?,?,?,?,?,?)";
        return CrudUtil.execute(sql,
                batch.getCode(),
                batch.getBarcode(),
                batch.getQtyOnHand(),
                batch.getSellingPrice(),
                batch.isAvailable(),
                batch.getShowPrice(),
                batch.getBuyingPrice(),
                batch.getProductCode()
        );

    }

    @Override
    public boolean update(Batch batch) throws Exception, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception, ClassNotFoundException {
        return false;
    }

    @Override
    public Batch find(String s) throws Exception, ClassNotFoundException {

        String sql = "SELECT * FROM batch WHERE code=?";
        ResultSet set = CrudUtil.execute(sql, s);

        if (set.next()) {
            return new Batch(
                    set.getString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getDouble(4),
                    set.getBoolean(5),
                    set.getDouble(6),
                    set.getDouble(7),
                    set.getInt(8)
            );
        }
        return null;
    }

    @Override
    public List<Batch> findAll() throws Exception, ClassNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public List<Batch> search(String s) throws Exception, ClassNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public List<Batch> findAllBatch(int productCode) throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM batch WHERE product_code1   = ?";
        ResultSet set = CrudUtil.execute(sql, productCode);

        List<Batch> list = new ArrayList<>();

        while (set.next()) {
            list.add(new Batch(
                    set.getString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getDouble(4),
                    set.getBoolean(5),
                    set.getDouble(6),
                    set.getDouble(7),
                    set.getInt(8)
            ));
        }
        return list;
    }

    @Override
    public ProductDetailJoinDTO findProductDetailJoinData(String code) throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM batch b JOIN product p ON b.code=? AND b.product_code1  = p.code";
        ResultSet resultSet = CrudUtil.execute(sql, code);

        if (resultSet.next()) {
            return new ProductDetailJoinDTO(
                    resultSet.getInt(9),
                    resultSet.getString(10),
                    new BatchDTO(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getDouble(4),
                            resultSet.getBoolean(5),
                            resultSet.getDouble(6),
                            resultSet.getDouble(7),
                            resultSet.getInt(8)
                    )
            );
        }
        return null;
    }

}
