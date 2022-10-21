package com.gxa.mapper;

import com.gxa.dto.WReceiptDetailsAddDto;
import com.gxa.entity.WReceiptDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WReceiptDetailsMapper {

    void add(List<WReceiptDetailsAddDto> wReceiptDetailsAddDtos);

    List<WReceiptDetails> queryByReceiptNo(@Param("receiptNo") Integer receiptNo);


}
