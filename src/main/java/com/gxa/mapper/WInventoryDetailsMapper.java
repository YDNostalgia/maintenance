package com.gxa.mapper;

import com.gxa.dto.WInventoryDetailsAddDto;
import com.gxa.entity.WInventoryDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WInventoryDetailsMapper {
    List<WInventoryDetails> queryByInventoryNo(@Param("inventoryNo") Integer inventoryNo);
    void add(List<WInventoryDetailsAddDto> wInventoryDetailsAddDtos);

    void delete(Integer inventoryNo);
}
