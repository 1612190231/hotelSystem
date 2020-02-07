package com.hotel.luck.dao;

import com.hotel.luck.bean.lockUsing;
import com.hotel.luck.bean.lockUsingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface lockUsingMapper {
    long countByExample(lockUsingExample example);

    int deleteByExample(lockUsingExample example);

    int deleteByPrimaryKey(Integer lockusingId);

    int insert(lockUsing record);

    int insertSelective(lockUsing record);

    List<lockUsing> selectByExample(lockUsingExample example);

    lockUsing selectByPrimaryKey(Integer lockusingId);

    int updateByExampleSelective(@Param("record") lockUsing record, @Param("example") lockUsingExample example);

    int updateByExample(@Param("record") lockUsing record, @Param("example") lockUsingExample example);

    int updateByPrimaryKeySelective(lockUsing record);

    int updateByPrimaryKey(lockUsing record);
}