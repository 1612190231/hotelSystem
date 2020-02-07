package com.hotel.luck.dao;

import com.hotel.luck.bean.assess;
import com.hotel.luck.bean.assessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface assessMapper {
    long countByExample(assessExample example);

    int deleteByExample(assessExample example);

    int deleteByPrimaryKey(Integer assessId);

    int insert(assess record);

    int insertSelective(assess record);

    List<assess> selectByExample(assessExample example);

    assess selectByPrimaryKey(Integer assessId);

    int updateByExampleSelective(@Param("record") assess record, @Param("example") assessExample example);

    int updateByExample(@Param("record") assess record, @Param("example") assessExample example);

    int updateByPrimaryKeySelective(assess record);

    int updateByPrimaryKey(assess record);
}