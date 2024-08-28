package com.dev.pos.bo.custom;

import com.dev.pos.bo.SuperBo;
import com.dev.pos.dto.BatchDTO;

import java.util.List;

public interface BatchBo extends SuperBo {

    public boolean saveBatch(BatchDTO dto) throws Exception;

    public List<BatchDTO> findAllBatch(int productCode) throws Exception;

}
