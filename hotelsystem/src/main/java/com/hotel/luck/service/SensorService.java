package com.hotel.luck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.friendInfoExample;
import com.hotel.luck.bean.sensorInfo;
import com.hotel.luck.bean.sensorUsing;
import com.hotel.luck.bean.sensorUsingExample;
import com.hotel.luck.dao.sensorUsingMapper;
import com.hotel.luck.dao.sensorInfoMapper;
@Service
public class SensorService {
	@Autowired
	sensorInfoMapper sensorInfoMapper;
	@Autowired
	sensorUsingMapper sensorUsingMapper;


	//增加传感器信息
	public int insertinfo(sensorInfo sensorinfo) {
		// TODO Auto-generated method stub
		return sensorInfoMapper.insert(sensorinfo);
	}

	//增加传感器定时回传记录
	public int insertmsg(sensorUsing sensorusing) {
		// TODO Auto-generated method stub
		return sensorUsingMapper.insert(sensorusing);
	}
	
	//查询指定传感器信息
	public sensorInfo selectinfo(int id) {
		// TODO Auto-generated method stub
		return sensorInfoMapper.selectByPrimaryKey(id);
	}
	
	//查询指定传感器信息
	public List<sensorUsing> selectUsing(int id) {
		// TODO Auto-generated method stub
		sensorUsingExample sensorUsingexample = new sensorUsingExample();
		sensorUsingexample.setOrderByClause("hotel_id asc"); //asc升序,desc降序排列
		sensorUsingexample.setDistinct(false); //去除重复,true是选择不重复记录,false反之
		sensorUsingExample.Criteria criteria = sensorUsingexample.createCriteria(); //构造自定义查询条件
			criteria.andHotelIdEqualTo(id);
		 
		//自定义查询条件可能返回多条记录,使用List接收
		return sensorUsingMapper.selectByExample(sensorUsingexample);
	}
	
	//更新传感器信息
	public int updateinfo(sensorInfo sensorinfo) {
		// TODO Auto-generated method stub
		return sensorInfoMapper.updateByPrimaryKey(sensorinfo);
	}
	
	//查询所有传感器信息
	public List<sensorInfo> getAllInfo() {
		// TODO Auto-generated method stub
		return sensorInfoMapper.selectByExample(null);
	}
	
	//查询所有传感器信息
	public List<sensorUsing> getAllUsing() {
		// TODO Auto-generated method stub
		return sensorUsingMapper.selectByExample(null);
	}
	
	//删除传感器信息
	public int deleteinfo(int id) {
		// TODO Auto-generated method stub
		return sensorInfoMapper.deleteByPrimaryKey(id);
	}
}
