package com.hotel.luck.dao;

import com.hotel.luck.bean.privilege;
import com.hotel.luck.bean.privilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface privilegeMapper {
    long countByExample(privilegeExample example);

    int deleteByExample(privilegeExample example);

    int deleteByPrimaryKey(Integer privilegeId);

    int insert(privilege record);

    int insertSelective(privilege record);

    List<privilege> selectByExample(privilegeExample example);

    privilege selectByPrimaryKey(Integer privilegeId);

    int updateByExampleSelective(@Param("record") privilege record, @Param("example") privilegeExample example);

    int updateByExample(@Param("record") privilege record, @Param("example") privilegeExample example);

    int updateByPrimaryKeySelective(privilege record);

    int updateByPrimaryKey(privilege record);
}