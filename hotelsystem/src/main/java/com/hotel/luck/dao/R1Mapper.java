package com.hotel.luck.dao;

import com.hotel.luck.bean.R1;
import com.hotel.luck.bean.R1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface R1Mapper {
    long countByExample(R1Example example);

    int deleteByExample(R1Example example);

    int deleteByPrimaryKey(Integer r1id);

    int insert(R1 record);

    int insertSelective(R1 record);

    List<R1> selectByExample(R1Example example);

    R1 selectByPrimaryKey(Integer r1id);

    int updateByExampleSelective(@Param("record") R1 record, @Param("example") R1Example example);

    int updateByExample(@Param("record") R1 record, @Param("example") R1Example example);

    int updateByPrimaryKeySelective(R1 record);

    int updateByPrimaryKey(R1 record);
}