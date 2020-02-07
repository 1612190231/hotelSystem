package com.hotel.luck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.orderInfo;
import com.hotel.luck.bean.orderInfoExample;
import com.hotel.luck.dao.orderInfoMapper;
@Service
public class OrderService {
	@Autowired
	orderInfoMapper orederinfoMapper;

	//添加订单
	public int insert(orderInfo orderinfo) {
		// TODO Auto-generated method stub
		return orederinfoMapper.insert(orderinfo);
	 
	}

	//查询订单
	public orderInfo selectOrder(int id) {
		// TODO Auto-generated method stub	
		return orederinfoMapper.selectByPrimaryKey(id);
	}
	
	//查询所有订单
	public List<orderInfo> selectAllOrder() {
		// TODO Auto-generated method stub	
		return orederinfoMapper.selectByExample(null);
	}
	
	//更新订单
	public int updateOrder(orderInfo orderinfo) {
		// TODO Auto-generated method stub	
		return orederinfoMapper.updateByPrimaryKey(orderinfo);
	}
	
	//查询房间订单
	public List<orderInfo> selectHotel(int id) {
		// TODO Auto-generated method stub
		orderInfoExample orderinfoexample = new orderInfoExample();
		orderinfoexample.setOrderByClause("hotel_id asc"); //asc����,desc��������
		orderinfoexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		orderInfoExample.Criteria criteria = orderinfoexample.createCriteria(); //�����Զ����ѯ����
	       criteria.andHotelIdEqualTo(id);
	 
	    //�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return orederinfoMapper.selectByExample(orderinfoexample);
	}
		
	//查询用户订单
	public List<orderInfo> selectUser(int id) {
		// TODO Auto-generated method stub
		orderInfoExample orderinfoexample = new orderInfoExample();
		orderinfoexample.setOrderByClause("user_id asc"); //asc����,desc��������
		orderinfoexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		orderInfoExample.Criteria criteria = orderinfoexample.createCriteria(); //�����Զ����ѯ����
	    criteria.andUserIdEqualTo(id);
	 
	    //�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return orederinfoMapper.selectByExample(orderinfoexample);
	}

	//删除订单
	public int delete(int id) {
		// TODO Auto-generated method stub
		return orederinfoMapper.deleteByPrimaryKey(id);
	 }

}
