package com.gxa.mapper;


import org.apache.ibatis.annotations.Param;

public interface PersonalSubmitMapper {
    public void addPersonalSubmit(@Param("personalId") Integer personalId, @Param("keepRecordId") Integer keepRecordId);
}
