package com.dev.pos.dao.custom;

import com.dev.pos.dao.CrudDao;
import com.dev.pos.entity.Batch;

import java.sql.SQLException;
import java.util.List;

public interface BatchDao extends CrudDao<Batch,String> {

    public List<Batch> findAllBatch(int productCode) throws SQLException, ClassNotFoundException;

}