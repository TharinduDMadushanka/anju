package com.dev.pos.bo.custom;

import com.dev.pos.dto.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailBo {
    public boolean makeOrder(OrderDetailDTO dto) throws SQLException;
}
