package com.hotel.luck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.lockUsing;
import com.hotel.luck.bean.lockUsingExample;
import com.hotel.luck.bean.userInfo;
import com.hotel.luck.bean.userInfoExample;
import com.hotel.luck.dao.userInfoMapper;
@Service
public class UserInfoService {
	@Autowired
	userInfoMapper userInfoMapper;

	//增加用户信息
	public int insert(userInfo userinfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.insert(userinfo);
	}
	
	//查询单个用户信息
	public userInfo select(int userid) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectByPrimaryKey(userid);
	}
	
	//获取所有用户信息
	public List<userInfo> getAll() {
		// TODO Auto-generated method stub
		return userInfoMapper.selectByExample(null);
	}
	
	//更改用户信息
	public int update(userInfo userinfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.updateByPrimaryKey(userinfo);

	}
	
	//根据性别搜索用户
	public List<userInfo> selectBySex(String sex) {
		// TODO Auto-generated method stub
		userInfoExample userInfoexample = new userInfoExample();
		userInfoexample.setDistinct(false); //去除重复,true是选择不重复记录,false反之
		userInfoExample.Criteria criteria = userInfoexample.createCriteria(); //构造自定义查询条件
		criteria.andSexEqualTo(sex);
			 
		//自定义查询条件可能返回多条记录,使用List接收
		return userInfoMapper.selectByExample(userInfoexample);
	}
	//根据用户名搜索用户
	public List<userInfo> selectByName(String name) {
		// TODO Auto-generated method stub
		userInfoExample userInfoexample = new userInfoExample();
		userInfoexample.setDistinct(false); //去除重复,true是选择不重复记录,false反之
		userInfoExample.Criteria criteria = userInfoexample.createCriteria(); //构造自定义查询条件
		criteria.andUserNameEqualTo(name);
				 
		//自定义查询条件可能返回多条记录,使用List接收
		return userInfoMapper.selectByExample(userInfoexample);
	}
	//根据年龄搜索用户
	public List<userInfo> selectByAge(int age) {
		// TODO Auto-generated method stub
		userInfoExample userInfoexample = new userInfoExample();
		userInfoexample.setDistinct(false); //去除重复,true是选择不重复记录,false反之
		userInfoExample.Criteria criteria = userInfoexample.createCriteria(); //构造自定义查询条件
		criteria.andAgeEqualTo(age);
					 
		//自定义查询条件可能返回多条记录,使用List接收
		return userInfoMapper.selectByExample(userInfoexample);
	}
	
}
