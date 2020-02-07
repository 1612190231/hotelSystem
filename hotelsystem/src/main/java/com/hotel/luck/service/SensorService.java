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


	//���Ӵ�������Ϣ
	public int insertinfo(sensorInfo sensorinfo) {
		// TODO Auto-generated method stub
		return sensorInfoMapper.insert(sensorinfo);
	}

	//���Ӵ�������ʱ�ش���¼
	public int insertmsg(sensorUsing sensorusing) {
		// TODO Auto-generated method stub
		return sensorUsingMapper.insert(sensorusing);
	}
	
	//��ѯָ����������Ϣ
	public sensorInfo selectinfo(int id) {
		// TODO Auto-generated method stub
		return sensorInfoMapper.selectByPrimaryKey(id);
	}
	
	//��ѯָ����������Ϣ
	public List<sensorUsing> selectUsing(int id) {
		// TODO Auto-generated method stub
		sensorUsingExample sensorUsingexample = new sensorUsingExample();
		sensorUsingexample.setOrderByClause("hotel_id asc"); //asc����,desc��������
		sensorUsingexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		sensorUsingExample.Criteria criteria = sensorUsingexample.createCriteria(); //�����Զ����ѯ����
			criteria.andHotelIdEqualTo(id);
		 
		//�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return sensorUsingMapper.selectByExample(sensorUsingexample);
	}
	
	//���´�������Ϣ
	public int updateinfo(sensorInfo sensorinfo) {
		// TODO Auto-generated method stub
		return sensorInfoMapper.updateByPrimaryKey(sensorinfo);
	}
	
	//��ѯ���д�������Ϣ
	public List<sensorInfo> getAllInfo() {
		// TODO Auto-generated method stub
		return sensorInfoMapper.selectByExample(null);
	}
	
	//��ѯ���д�������Ϣ
	public List<sensorUsing> getAllUsing() {
		// TODO Auto-generated method stub
		return sensorUsingMapper.selectByExample(null);
	}
	
	//ɾ����������Ϣ
	public int deleteinfo(int id) {
		// TODO Auto-generated method stub
		return sensorInfoMapper.deleteByPrimaryKey(id);
	}
}
