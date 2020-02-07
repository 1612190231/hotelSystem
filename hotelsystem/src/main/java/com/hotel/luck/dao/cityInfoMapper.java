package com.hotel.luck.dao;

import com.hotel.luck.bean.cityInfo;
import com.hotel.luck.bean.cityInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface cityInfoMapper {
    long countByExample(cityInfoExample example);

    int deleteByExample(cityInfoExample example);

    int deleteByPrimaryKey(Integer cityId);

    int insert(cityInfo record);

    int insertSelective(cityInfo record);

    List<cityInfo> selectByExample(cityInfoExample example);

    cityInfo selectByPrimaryKey(Integer cityId);

    int updateByExampleSelective(@Param("record") cityInfo record, @Param("example") cityInfoExample example);

    int updateByExample(@Param("record") cityInfo record, @Param("example") cityInfoExample example);

    int updateByPrimaryKeySelective(cityInfo record);

    int updateByPrimaryKey(cityInfo record);
}