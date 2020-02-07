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

	//�����û���Ϣ
	public int insert(userInfo userinfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.insert(userinfo);
	}
	
	//��ѯ�����û���Ϣ
	public userInfo select(int userid) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectByPrimaryKey(userid);
	}
	
	//��ȡ�����û���Ϣ
	public List<userInfo> getAll() {
		// TODO Auto-generated method stub
		return userInfoMapper.selectByExample(null);
	}
	
	//�����û���Ϣ
	public int update(userInfo userinfo) {
		// TODO Auto-generated method stub
		return userInfoMapper.updateByPrimaryKey(userinfo);

	}
	
	//�����Ա������û�
	public List<userInfo> selectBySex(String sex) {
		// TODO Auto-generated method stub
		userInfoExample userInfoexample = new userInfoExample();
		userInfoexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		userInfoExample.Criteria criteria = userInfoexample.createCriteria(); //�����Զ����ѯ����
		criteria.andSexEqualTo(sex);
			 
		//�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return userInfoMapper.selectByExample(userInfoexample);
	}
	//�����û��������û�
	public List<userInfo> selectByName(String name) {
		// TODO Auto-generated method stub
		userInfoExample userInfoexample = new userInfoExample();
		userInfoexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		userInfoExample.Criteria criteria = userInfoexample.createCriteria(); //�����Զ����ѯ����
		criteria.andUserNameEqualTo(name);
				 
		//�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return userInfoMapper.selectByExample(userInfoexample);
	}
	//�������������û�
	public List<userInfo> selectByAge(int age) {
		// TODO Auto-generated method stub
		userInfoExample userInfoexample = new userInfoExample();
		userInfoexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		userInfoExample.Criteria criteria = userInfoexample.createCriteria(); //�����Զ����ѯ����
		criteria.andAgeEqualTo(age);
					 
		//�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return userInfoMapper.selectByExample(userInfoexample);
	}
	
}
