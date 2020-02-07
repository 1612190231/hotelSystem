package com.hotel.luck.dao;

import com.hotel.luck.bean.provinceInfo;
import com.hotel.luck.bean.provinceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface provinceInfoMapper {
    long countByExample(provinceInfoExample example);

    int deleteByExample(provinceInfoExample example);

    int deleteByPrimaryKey(Integer provinceId);

    int insert(provinceInfo record);

    int insertSelective(provinceInfo record);

    List<provinceInfo> selectByExample(provinceInfoExample example);

    provinceInfo selectByPrimaryKey(Integer provinceId);

    int updateByExampleSelective(@Param("record") provinceInfo record, @Param("example") provinceInfoExample example);

    int updateByExample(@Param("record") provinceInfo record, @Param("example") provinceInfoExample example);

    int updateByPrimaryKeySelective(provinceInfo record);

    int updateByPrimaryKey(provinceInfo record);
}