package com.hotel.luck.dao;

import com.hotel.luck.bean.hotelInfo;
import com.hotel.luck.bean.hotelInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface hotelInfoMapper {
    long countByExample(hotelInfoExample example);

    int deleteByExample(hotelInfoExample example);

    int deleteByPrimaryKey(Integer hotelId);

    int insert(hotelInfo record);

    int insertSelective(hotelInfo record);

    List<hotelInfo> selectByExample(hotelInfoExample example);

    hotelInfo selectByPrimaryKey(Integer hotelId);

    int updateByExampleSelective(@Param("record") hotelInfo record, @Param("example") hotelInfoExample example);

    int updateByExample(@Param("record") hotelInfo record, @Param("example") hotelInfoExample example);

    int updateByPrimaryKeySelective(hotelInfo record);

    int updateByPrimaryKey(hotelInfo record);
}