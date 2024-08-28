package com.dev.pos.dao.impl;

import com.dev.pos.dao.CrudUtil;
import com.dev.pos.dao.custom.BatchDao;
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

}
