package com.dev.pos.dao.impl;

import com.dev.pos.dao.CrudUtil;
import com.dev.pos.dao.custom.OrderDetailDao;
import com.dev.pos.entity.OrderDetail;

import java.util.Collections;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    public List<OrderDetail> findAll() throws Exception, ClassNotFoundException {
        return Collections.emptyList();
    }

    @Override
    public boolean save(OrderDetail orderDetail) throws Exception, ClassNotFoundException {
        String sql = "INSERT INTO order_details VALUES(?,?,?,?,?,?)";
        return CrudUtil.execute(sql,
                orderDetail.getCode(),
                orderDetail.getIssueDate(),
                orderDetail.getTotalCost(),
                orderDetail.getCustomerEmail(),
                orderDetail.getDiscount(),
                orderDetail.getUsrEmail()
        );
    }

    @Override
    public boolean update(OrderDetail orderDetail) throws Exception, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws Exception, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetail find(Integer integer) throws Exception, ClassNotFoundException {
        return null;
    }

    @Override
    public List<OrderDetail> search(Integer integer) throws Exception, ClassNotFoundException {
        return Collections.emptyList();
    }
}
