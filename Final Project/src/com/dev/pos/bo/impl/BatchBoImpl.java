package com.dev.pos.bo.impl;

import com.dev.pos.Enum.DaoType;
import com.dev.pos.bo.custom.BatcgBo;
import com.dev.pos.dao.DaoFactory;
import com.dev.pos.dao.custom.BatchDao;
import com.dev.pos.dto.BatchDTO;
import com.dev.pos.entity.Batch;

public class BatchBoImpl implements BatcgBo {

    BatchDao batchDao = (BatchDao) DaoFactory.getInstance().getDao(DaoType.BATCH);

    @Override
    public boolean saveBatch(BatchDTO dto) throws Exception {

        return batchDao.save(new Batch(
                dto.getCode(),
                dto.getBarcode(),
                dto.getQtyOnHand(),
                dto.getSellingPrice(),
                dto.isAvailable(),
                dto.getShowPrice(),
                dto.getBuyingPrice(),
                dto.getProductCode()
        ));

    }
}
