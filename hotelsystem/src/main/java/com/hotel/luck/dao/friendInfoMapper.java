package com.hotel.luck.dao;

import com.hotel.luck.bean.friendInfo;
import com.hotel.luck.bean.friendInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface friendInfoMapper {
    long countByExample(friendInfoExample example);

    int deleteByExample(friendInfoExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(friendInfo record);

    int insertSelective(friendInfo record);

    List<friendInfo> selectByExample(friendInfoExample example);

    friendInfo selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") friendInfo record, @Param("example") friendInfoExample example);

    int updateByExample(@Param("record") friendInfo record, @Param("example") friendInfoExample example);

    int updateByPrimaryKeySelective(friendInfo record);

    int updateByPrimaryKey(friendInfo record);
}