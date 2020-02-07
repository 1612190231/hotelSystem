package com.hotel.luck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.provinceInfo;
import com.hotel.luck.dao.provinceInfoMapper;
@Service
public class ProvinceService {
	@Autowired
	provinceInfoMapper provinceInfoMapper;

	//增加省会信息
	public int insert(provinceInfo provinceinfo) {
		// TODO Auto-generated method stub
		return provinceInfoMapper.insert(provinceinfo);
	 
}

	//查询所有省会信息
	public List<provinceInfo> getAll() {
		// TODO Auto-generated method stub
		return provinceInfoMapper.selectByExample(null);
	}

	//删除指定省会信息
	public int delete(int id) {
		// TODO Auto-generated method stub
		return provinceInfoMapper.deleteByPrimaryKey(id);
	 }

}
