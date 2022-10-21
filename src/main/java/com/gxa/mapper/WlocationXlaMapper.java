package com.gxa.mapper;

import com.gxa.entity.WLocation;

import java.util.List;

public interface WlocationXlaMapper {
    public List<WLocation> queryByWregionId(Integer wRegionId);
}
