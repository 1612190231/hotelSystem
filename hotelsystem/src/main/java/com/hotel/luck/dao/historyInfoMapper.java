package com.hotel.luck.dao;

import com.hotel.luck.bean.historyInfo;
import com.hotel.luck.bean.historyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface historyInfoMapper {
    long countByExample(historyInfoExample example);

    int deleteByExample(historyInfoExample example);

    int deleteByPrimaryKey(Integer historyId);

    int insert(historyInfo record);

    int insertSelective(historyInfo record);

    List<historyInfo> selectByExample(historyInfoExample example);

    historyInfo selectByPrimaryKey(Integer historyId);

    int updateByExampleSelective(@Param("record") historyInfo record, @Param("example") historyInfoExample example);

    int updateByExample(@Param("record") historyInfo record, @Param("example") historyInfoExample example);

    int updateByPrimaryKeySelective(historyInfo record);

    int updateByPrimaryKey(historyInfo record);
}