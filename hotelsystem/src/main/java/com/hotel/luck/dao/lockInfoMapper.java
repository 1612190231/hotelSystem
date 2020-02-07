package com.hotel.luck.dao;

import com.hotel.luck.bean.lockInfo;
import com.hotel.luck.bean.lockInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface lockInfoMapper {
    long countByExample(lockInfoExample example);

    int deleteByExample(lockInfoExample example);

    int deleteByPrimaryKey(Integer lockId);

    int insert(lockInfo record);

    int insertSelective(lockInfo record);

    List<lockInfo> selectByExample(lockInfoExample example);

    lockInfo selectByPrimaryKey(Integer lockId);

    int updateByExampleSelective(@Param("record") lockInfo record, @Param("example") lockInfoExample example);

    int updateByExample(@Param("record") lockInfo record, @Param("example") lockInfoExample example);

    int updateByPrimaryKeySelective(lockInfo record);

    int updateByPrimaryKey(lockInfo record);
}