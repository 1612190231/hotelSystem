package com.hotel.luck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.adminInfo;
import com.hotel.luck.bean.userInfo;
import com.hotel.luck.dao.adminInfoMapper;

@Service
public class AdminService {
	@Autowired
	adminInfoMapper admininfoMapper;
	
	//获取所有用户信息
	public List<adminInfo> getAll() {
		// TODO Auto-generated method stub
		return admininfoMapper.selectByExample(null);
	}
}
