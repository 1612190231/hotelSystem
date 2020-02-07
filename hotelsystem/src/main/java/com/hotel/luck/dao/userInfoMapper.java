package com.hotel.luck.dao;

import com.hotel.luck.bean.userInfo;
import com.hotel.luck.bean.userInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userInfoMapper {
    long countByExample(userInfoExample example);

    int deleteByExample(userInfoExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(userInfo record);

    int insertSelective(userInfo record);

    List<userInfo> selectByExample(userInfoExample example);

    userInfo selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") userInfo record, @Param("example") userInfoExample example);

    int updateByExample(@Param("record") userInfo record, @Param("example") userInfoExample example);

    int updateByPrimaryKeySelective(userInfo record);

    int updateByPrimaryKey(userInfo record);
}