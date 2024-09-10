package com.dev.pos.bo.impl;

import com.dev.pos.Enum.DaoType;
import com.dev.pos.bo.custom.OrderDetailBo;
import com.dev.pos.dao.DaoFactory;
import com.dev.pos.dao.custom.BatchDao;
import com.dev.pos.dao.custom.ItemDetailDao;
import com.dev.pos.dao.custom.OrderDetailDao;
import com.dev.pos.dao.impl.OrderDetailDaoImpl;
import com.dev.pos.db.DBConnection;
import com.dev.pos.dto.ItemDetailDTO;
import com.dev.pos.dto.OrderDetailDTO;
import com.dev.pos.entity.Batch;
import com.dev.pos.entity.ItemDetail;
import com.dev.pos.entity.OrderDetail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailBoImpl implements OrderDetailBo {

    OrderDetailDao detailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoType.ORDER_DETAIL);
    ItemDetailDao itemDetailDao = (ItemDetailDao) DaoFactory.getInstance().getDao(DaoType.ITEM_DETAIL);
    BatchDao batchDao = (BatchDao) DaoFactory.getInstance().getDao(DaoType.BATCH);

    @Override
    public boolean makeOrder(OrderDetailDTO dto) throws SQLException {

        Connection connection = null;

        try {

            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            OrderDetail orderDetail = new OrderDetail(
                    dto.getCode(),
                    dto.getIssueDate(),
                    dto.getTotalCost(),
                    dto.getCustomerEmail(),
                    dto.getDiscount(),
                    dto.getUsrEmail()
            );


            boolean isOrderSave = detailDao.save(orderDetail);

            if (isOrderSave) {
                //item save

                boolean isItemDetailSave = saveItemDetails(dto.getDtoList(), dto.getCode());

                if (isItemDetailSave) {
                    connection.commit();
                    return true;
                }else {
                    connection.rollback();
                    return false;
                }

            } else {
                connection.rollback();
                return false;
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            connection.setAutoCommit(true);
        }
        return false;
    }

    private boolean saveItemDetails(List<ItemDetailDTO> list, int oredrCode) throws Exception {

        for (ItemDetailDTO dto : list) {
            boolean isItemSave = itemDetailDao.save(new ItemDetail(
                    oredrCode,
                    dto.getDetailCode(),
                    dto.getQty(),
                    dto.getDiscount(),
                    dto.getAmount()
            ));

            if (isItemSave) {
                if (!updateQty(dto.getDetailCode(), dto.getQty())) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean updateQty(String barcode, int qty) throws SQLException, ClassNotFoundException {
        return batchDao.manageQty(barcode, qty);
    }
}
