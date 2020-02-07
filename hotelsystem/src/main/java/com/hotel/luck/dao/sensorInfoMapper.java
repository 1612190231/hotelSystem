package com.hotel.luck.dao;

import com.hotel.luck.bean.sensorInfo;
import com.hotel.luck.bean.sensorInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface sensorInfoMapper {
    long countByExample(sensorInfoExample example);

    int deleteByExample(sensorInfoExample example);

    int deleteByPrimaryKey(Integer sensorId);

    int insert(sensorInfo record);

    int insertSelective(sensorInfo record);

    List<sensorInfo> selectByExample(sensorInfoExample example);

    sensorInfo selectByPrimaryKey(Integer sensorId);

    int updateByExampleSelective(@Param("record") sensorInfo record, @Param("example") sensorInfoExample example);

    int updateByExample(@Param("record") sensorInfo record, @Param("example") sensorInfoExample example);

    int updateByPrimaryKeySelective(sensorInfo record);

    int updateByPrimaryKey(sensorInfo record);
}