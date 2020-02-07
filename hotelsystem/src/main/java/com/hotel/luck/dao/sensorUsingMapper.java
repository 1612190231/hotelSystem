package com.hotel.luck.dao;

import com.hotel.luck.bean.sensorUsing;
import com.hotel.luck.bean.sensorUsingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface sensorUsingMapper {
    long countByExample(sensorUsingExample example);

    int deleteByExample(sensorUsingExample example);

    int deleteByPrimaryKey(Integer sensorusingId);

    int insert(sensorUsing record);

    int insertSelective(sensorUsing record);

    List<sensorUsing> selectByExample(sensorUsingExample example);

    sensorUsing selectByPrimaryKey(Integer sensorusingId);

    int updateByExampleSelective(@Param("record") sensorUsing record, @Param("example") sensorUsingExample example);

    int updateByExample(@Param("record") sensorUsing record, @Param("example") sensorUsingExample example);

    int updateByPrimaryKeySelective(sensorUsing record);

    int updateByPrimaryKey(sensorUsing record);
}