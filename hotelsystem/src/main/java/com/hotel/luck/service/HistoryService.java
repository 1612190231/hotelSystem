package com.hotel.luck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.historyInfo;
import com.hotel.luck.bean.historyInfoExample;
import com.hotel.luck.dao.historyInfoMapper;
@Service
public class HistoryService {
	@Autowired
	historyInfoMapper historyInfoMapper;

	//添加历史消息
	public int insert(historyInfo historyinfo) {
		// TODO Auto-generated method stub
		return historyInfoMapper.insert(historyinfo);
	 
	}

	//查询房间订单
	public historyInfo selectHistory(int id) {
		// TODO Auto-generated method stub
	 
	    //�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return historyInfoMapper.selectByPrimaryKey(id);
	}
	
	//查询房间订单
	public List<historyInfo> selectHotel(int id) {
		// TODO Auto-generated method stub
		historyInfoExample historyinfoexample = new historyInfoExample();
		historyinfoexample.setOrderByClause("hotelId asc"); //asc����,desc��������
		historyinfoexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		historyInfoExample.Criteria criteria = historyinfoexample.createCriteria(); //�����Զ����ѯ����
	       criteria.andHotelIdEqualTo(id);
	 
	    //�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return historyInfoMapper.selectByExample(historyinfoexample);
	}
		
	//查询用户信息
	public List<historyInfo> selectUser(int id) {
		// TODO Auto-generated method stub
		historyInfoExample historyinfoexample = new historyInfoExample();
		historyinfoexample.setOrderByClause("userId asc"); //asc����,desc��������
		historyinfoexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		historyInfoExample.Criteria criteria = historyinfoexample.createCriteria(); //�����Զ����ѯ����
	    criteria.andUserIdEqualTo(id);
	 
	    //�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return historyInfoMapper.selectByExample(historyinfoexample);
	}

	//删除订单信息
	public int delete(int id) {
		// TODO Auto-generated method stub
		return historyInfoMapper.deleteByPrimaryKey(id);
	}

	//更新
	public int update(historyInfo historyinfo) {
		// TODO Auto-generated method stub
		return historyInfoMapper.updateByPrimaryKey(historyinfo);
	}
}
