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

	//����������Ϣ
	public int insertinfo(lockInfo lockinfo) {
		// TODO Auto-generated method stub
		return lockInfoMapper.insert(lockinfo);
	}

	//���ӿ��ż�¼
	public int insertmsg(lockUsing lockusing) {
		// TODO Auto-generated method stub
		return lockUsingMapper.insert(lockusing);
	}
	
	//��ѯָ��������Ϣ
	public lockInfo selectinfo(int id) {
		// TODO Auto-generated method stub
		return lockInfoMapper.selectByPrimaryKey(id);
	}
	
	//����������Ϣ
	public int updateinfo(lockInfo lockinfo) {
		// TODO Auto-generated method stub
		return lockInfoMapper.updateByPrimaryKey(lockinfo);
	}
	
	//��ѯ����������Ϣ
	public List<lockInfo> getAllInfo() {
		// TODO Auto-generated method stub
		return lockInfoMapper.selectByExample(null);
	}
	
	//ɾ��������Ϣ
	public int deleteinfo(int id) {
		// TODO Auto-generated method stub
		return lockInfoMapper.deleteByPrimaryKey(id);
	}
	
	//��ѯ���з���ˢ����¼
	public List<lockUsing> getAllUsing() {
		// TODO Auto-generated method stub
		return lockUsingMapper.selectByExample(null);
	}
	
	//��ѯָ������ˢ����¼
	public List<lockUsing> selectHotelUsing(int id) {
		// TODO Auto-generated method stub
		lockUsingExample lockUsingexample = new lockUsingExample();
		lockUsingexample.setOrderByClause("hotelId asc"); //asc����,desc��������
		lockUsingexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		lockUsingExample.Criteria criteria = lockUsingexample.createCriteria(); //�����Զ����ѯ����
		criteria.andHotelIdEqualTo(id);
		 
	    //�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return lockUsingMapper.selectByExample(lockUsingexample);
	}
	
	//��ѯָ���û�ˢ����¼
	public List<lockUsing> selectUserUsing(int id) {
		// TODO Auto-generated method stub
		lockUsingExample lockUsingexample = new lockUsingExample();
		lockUsingexample.setOrderByClause("userId asc"); //asc����,desc��������
		lockUsingexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		lockUsingExample.Criteria criteria = lockUsingexample.createCriteria(); //�����Զ����ѯ����
		criteria.andUserIdEqualTo(id);
			 
	    //�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return lockUsingMapper.selectByExample(lockUsingexample);
	}
}
