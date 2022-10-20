package com.gxa.mapper;

import com.gxa.entity.KeepStaute;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface KeepStauteMapper {
    List<KeepStaute> queryAllKeepStaute();
}
