package com.hotel.luck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.historyInfo;
import com.hotel.luck.bean.historyInfoExample;
import com.hotel.luck.bean.lockInfo;
import com.hotel.luck.bean.lockInfoExample;
import com.hotel.luck.bean.lockInfoExample.Criteria;
import com.hotel.luck.bean.lockUsing;
import com.hotel.luck.bean.lockUsingExample;
import com.hotel.luck.dao.lockUsingMapper;
import com.hotel.luck.dao.lockInfoMapper;
@Service
public class LockService {
	@Autowired
	lockInfoMapper lockInfoMapper;
	@Autowired
	lockUsingMapper lockUsingMapper;

	//增加门锁信息
	public int insertinfo(lockInfo lockinfo) {
		// TODO Auto-generated method stub
		return lockInfoMapper.insert(lockinfo);
	}

	//增加开门记录
	public int insertmsg(lockUsing lockusing) {
		// TODO Auto-generated method stub
		return lockUsingMapper.insert(lockusing);
	}
	
	//查询指定门锁信息
	public lockInfo selectinfo(int id) {
		// TODO Auto-generated method stub
		return lockInfoMapper.selectByPrimaryKey(id);
	}
	
	//更新门锁信息
	public int updateinfo(lockInfo lockinfo) {
		// TODO Auto-generated method stub
		return lockInfoMapper.updateByPrimaryKey(lockinfo);
	}
	
	//查询所有门锁信息
	public List<lockInfo> getAllInfo() {
		// TODO Auto-generated method stub
		return lockInfoMapper.selectByExample(null);
	}
	
	//删除门锁信息
	public int deleteinfo(int id) {
		// TODO Auto-generated method stub
		return lockInfoMapper.deleteByPrimaryKey(id);
	}
	
	//查询所有房间刷卡记录
	public List<lockUsing> getAllUsing() {
		// TODO Auto-generated method stub
		return lockUsingMapper.selectByExample(null);
	}
	
	//查询指定房间刷卡记录
	public List<lockUsing> selectHotelUsing(int id) {
		// TODO Auto-generated method stub
		lockUsingExample lockUsingexample = new lockUsingExample();
		lockUsingexample.setOrderByClause("hotelId asc"); //asc升序,desc降序排列
		lockUsingexample.setDistinct(false); //去除重复,true是选择不重复记录,false反之
		lockUsingExample.Criteria criteria = lockUsingexample.createCriteria(); //构造自定义查询条件
		criteria.andHotelIdEqualTo(id);
		 
	    //自定义查询条件可能返回多条记录,使用List接收
		return lockUsingMapper.selectByExample(lockUsingexample);
	}
	
	//查询指定用户刷卡记录
	public List<lockUsing> selectUserUsing(int id) {
		// TODO Auto-generated method stub
		lockUsingExample lockUsingexample = new lockUsingExample();
		lockUsingexample.setOrderByClause("userId asc"); //asc升序,desc降序排列
		lockUsingexample.setDistinct(false); //去除重复,true是选择不重复记录,false反之
		lockUsingExample.Criteria criteria = lockUsingexample.createCriteria(); //构造自定义查询条件
		criteria.andUserIdEqualTo(id);
			 
	    //自定义查询条件可能返回多条记录,使用List接收
		return lockUsingMapper.selectByExample(lockUsingexample);
	}
}
