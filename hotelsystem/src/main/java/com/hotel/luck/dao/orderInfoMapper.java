package com.hotel.luck.dao;

import com.hotel.luck.bean.orderInfo;
import com.hotel.luck.bean.orderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface orderInfoMapper {
    long countByExample(orderInfoExample example);

    int deleteByExample(orderInfoExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(orderInfo record);

    int insertSelective(orderInfo record);

    List<orderInfo> selectByExample(orderInfoExample example);

    orderInfo selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") orderInfo record, @Param("example") orderInfoExample example);

    int updateByExample(@Param("record") orderInfo record, @Param("example") orderInfoExample example);

    int updateByPrimaryKeySelective(orderInfo record);

    int updateByPrimaryKey(orderInfo record);
}