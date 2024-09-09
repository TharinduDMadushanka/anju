package com.dev.pos.dao.impl;

import com.dev.pos.dao.custom.ItemDetailDao;
import com.dev.pos.entity.ItemDetail;

import java.util.Collections;
import java.util.List;

public class ItemDetailDaoImpl implements ItemDetailDao {
    @Override
    public boolean save(ItemDetail itemDetail) throws Exception, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ItemDetail itemDetail) throws Exception, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws Exception, ClassNotFoundException {
        return false;
    }

    @Override
    public ItemDetail find(Integer integer) throws Exception, ClassNotFoundException {
        return null;
    }

    @Override
    public List<ItemDetail> findAll() throws Exception, ClassNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public List<ItemDetail> search(Integer integer) throws Exception, ClassNotFoundException {
        return Collections.emptyList();
    }
}
