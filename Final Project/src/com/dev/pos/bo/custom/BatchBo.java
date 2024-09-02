package com.dev.pos.bo.custom;

import com.dev.pos.bo.SuperBo;
import com.dev.pos.dto.BatchDTO;
import com.dev.pos.dto.ProductDetailJoinDTO;

import java.util.List;

public interface BatchBo extends SuperBo {

    public boolean saveBatch(BatchDTO dto) throws Exception;

    public List<BatchDTO> findAllBatch(int productCode) throws Exception;

    public BatchDTO findBatch(String code) throws Exception;

    public ProductDetailJoinDTO findProductJoinDetail(String code) throws Exception;
}
