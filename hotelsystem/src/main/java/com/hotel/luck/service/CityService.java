package com.hotel.luck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.cityInfo;
import com.hotel.luck.dao.cityInfoMapper;
@Service
public class CityService {
	@Autowired
	cityInfoMapper cityInfoMapper;

	//增加城市信息
	public int insert(cityInfo cityinfo) {
		// TODO Auto-generated method stub
		return cityInfoMapper.insert(cityinfo);
	 
}

	//查询所有城市信息
	public List<cityInfo> getAll() {
		// TODO Auto-generated method stub
		return cityInfoMapper.selectByExample(null);
	}
	
	//删除城市信息
	public int delete(int id) {
		// TODO Auto-generated method stub
		return cityInfoMapper.deleteByPrimaryKey(id);
	 
}
}
