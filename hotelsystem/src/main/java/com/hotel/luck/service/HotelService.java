package com.hotel.luck.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.hotelInfo;
import com.hotel.luck.bean.hotelInfoExample;
import com.hotel.luck.bean.userInfo;
import com.hotel.luck.bean.userInfoExample;
import com.hotel.luck.dao.hotelInfoMapper;

@Service
public class HotelService {
	@Autowired
	hotelInfoMapper hotelinfoMapper;

	//���ӷ�����Ϣ
	public int insert(hotelInfo hotelinfo) {
		// TODO Auto-generated method stub
		return hotelinfoMapper.insert(hotelinfo);
	}

	//��ѯ���з�����Ϣ
	public List<hotelInfo> getAll() {
		// TODO Auto-generated method stub
		return hotelinfoMapper.selectByExample(null);
	}
	
	//��ѯ����������Ϣ
	public hotelInfo selectHotel(int id) {
		// TODO Auto-generated method stub
		return hotelinfoMapper.selectByPrimaryKey(id);
	}

	
	//���ķ�����Ϣ
	public int update(hotelInfo hotelinfo) {
		// TODO Auto-generated method stub
		return hotelinfoMapper.updateByPrimaryKey(hotelinfo);

	}

	//ɾ��������Ϣ
	public int delete(int id) {
		// TODO Auto-generated method stub
		return hotelinfoMapper.deleteByPrimaryKey(id);
	}

	//根据省份搜索
	public List<hotelInfo> selectByProvince(String province) {
		// TODO Auto-generated method stub
		hotelInfoExample hotelInfoexample = new hotelInfoExample();
		hotelInfoexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		hotelInfoExample.Criteria criteria = hotelInfoexample.createCriteria(); //�����Զ����ѯ����
		criteria.andProvinceEqualTo(province);
						 
		//�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return hotelinfoMapper.selectByExample(hotelInfoexample);
	}
	
	//模糊搜索
	public List<hotelInfo> selectLike(String key) {
		// TODO Auto-generated method stub
		System.out.println(key);
		hotelInfoExample hotelInfoexample = new hotelInfoExample();
		hotelInfoexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		hotelInfoExample.Criteria criteria = hotelInfoexample.createCriteria(); //�����Զ����ѯ����
		criteria.andAddressLike("%" + key + "%"); //根据地址
		criteria.andCityLike("%" + key + "%"); //根据城市
		criteria.andProvinceLike("%" + key + "%"); //根据省份
		criteria.andNameLike("%" + key + "%"); //根据房间名
									 
		//�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return hotelinfoMapper.selectByExample(hotelInfoexample);
	}
	
	//���ݼ۸���������
	public List<hotelInfo> selectByPrice(BigDecimal key) {
		// TODO Auto-generated method stub
		hotelInfoExample hotelInfoexample = new hotelInfoExample();
		hotelInfoexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		hotelInfoExample.Criteria criteria = hotelInfoexample.createCriteria(); //�����Զ����ѯ����
		criteria.andPriceEqualTo(key);
										 
		//�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return hotelinfoMapper.selectByExample(hotelInfoexample);
	}
	
	//����������������
	public List<hotelInfo> selectByStar(int key) {
		// TODO Auto-generated method stub
		hotelInfoExample hotelInfoexample = new hotelInfoExample();
		hotelInfoexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		hotelInfoExample.Criteria criteria = hotelInfoexample.createCriteria(); //�����Զ����ѯ����
		criteria.andStarEqualTo(key);
											 
		//�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return hotelinfoMapper.selectByExample(hotelInfoexample);
	}
}
