package com.hotel.luck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.privilege;
import com.hotel.luck.bean.privilegeExample;
import com.hotel.luck.dao.privilegeMapper;
@Service
public class PrivilegeService {
	@Autowired
	privilegeMapper privilegeMapper;

	//����Ȩ��
	public int insert(privilege privilegeinfo) {
		// TODO Auto-generated method stub
		return privilegeMapper.insert(privilegeinfo);
	 }

	//��ѯ���з���Ȩ��
	public List<privilege> getAll() {
		// TODO Auto-generated method stub
		return privilegeMapper.selectByExample(null);
	}

	//查询房间权限
	public List<privilege> selectHotel(int id) {
		// TODO Auto-generated method stub
		privilegeExample privilegeexample = new privilegeExample();
		privilegeexample.setOrderByClause("hotel_id asc"); //asc����,desc��������
		privilegeExample.Criteria criteria = privilegeexample.createCriteria(); //�����Զ����ѯ����
	       criteria.andHotelIdEqualTo(id);
	 
	    //�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return privilegeMapper.selectByExample(privilegeexample);
	}
	
	//查询用户权限
	public List<privilege> selectUser(int id) {
		// TODO Auto-generated method stub
		privilegeExample privilegeexample = new privilegeExample();
		privilegeexample.setOrderByClause("user_id asc"); //asc����,desc��������
		privilegeexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		privilegeExample.Criteria criteria = privilegeexample.createCriteria(); //�����Զ����ѯ����
	       criteria.andUserIdEqualTo(id);
	 
	    //�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return privilegeMapper.selectByExample(privilegeexample);
	}

	//删除权限
	public int delete(int id) {
		// TODO Auto-generated method stub
		return privilegeMapper.deleteByPrimaryKey(id);
	}

	//删除指定订单的所有权限
	public int deleteOrder(int id) {
		// TODO Auto-generated method stub
		privilegeExample privilegeexample = new privilegeExample();
		privilegeexample.setOrderByClause("order_id asc"); //asc����,desc��������
		privilegeexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		privilegeExample.Criteria criteria = privilegeexample.createCriteria(); //�����Զ����ѯ����
			criteria.andOrderIdEqualTo(id);
			 
		//�Զ���ɾ���������ܷ��ض�����¼,ʹ��List����
		return privilegeMapper.deleteByExample(privilegeexample);
	}
}
