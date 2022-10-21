package com.gxa.mapper;

import com.gxa.dto.WReturnDetailsAddDto;
import com.gxa.entity.WReturnDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WReturnDetailsMapper {
    List<WReturnDetails> queryByReturnNo(@Param("returnNo") Integer returnNo);
    void add(List<WReturnDetailsAddDto> wReturnDetailsAddDtos);
    void delete(Integer returnNo);
}
