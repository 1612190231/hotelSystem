package com.hotel.luck.dao;

import com.hotel.luck.bean.adminInfo;
import com.hotel.luck.bean.adminInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface adminInfoMapper {
    long countByExample(adminInfoExample example);

    int deleteByExample(adminInfoExample example);

    int deleteByPrimaryKey(Integer adminId);

    int insert(adminInfo record);

    int insertSelective(adminInfo record);

    List<adminInfo> selectByExample(adminInfoExample example);

    adminInfo selectByPrimaryKey(Integer adminId);

    int updateByExampleSelective(@Param("record") adminInfo record, @Param("example") adminInfoExample example);

    int updateByExample(@Param("record") adminInfo record, @Param("example") adminInfoExample example);

    int updateByPrimaryKeySelective(adminInfo record);

    int updateByPrimaryKey(adminInfo record);
}