package com.gxa.service;

import com.gxa.entity.KeepStaute;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface KeepStauteSerivce {
    List<KeepStaute> queryAllKeepStaute();
}
