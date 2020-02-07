package com.hotel.luck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.assess;
import com.hotel.luck.bean.assessExample;
import com.hotel.luck.dao.assessMapper;
@Service
public class AssessService {
	@Autowired
	assessMapper assessMapper;

	//��������
	public int insertAssess(assess assess) {
		// TODO Auto-generated method stub
		return assessMapper.insert(assess);
	}
	
	//��ѯ��������
	public List<assess> selectHotel(int id) {
		// TODO Auto-generated method stub
		assessExample assessexample = new assessExample();
		assessexample.setOrderByClause("hotelId asc"); //asc����,desc��������
		assessexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		assessExample.Criteria criteria = assessexample.createCriteria(); //�����Զ����ѯ����
        criteria.andUserIdEqualTo(id);
 
        //�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return assessMapper.selectByExample(assessexample);
	}
	
	//��ѯ�û�����
	public List<assess> selectUser(int id) {
		// TODO Auto-generated method stub
		assessExample assessexample = new assessExample();
		assessexample.setOrderByClause("userId asc"); //asc����,desc��������
		assessexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		assessExample.Criteria criteria = assessexample.createCriteria(); //�����Զ����ѯ����
        criteria.andUserIdEqualTo(id);
 
        //�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return assessMapper.selectByExample(assessexample);
	}

	//ɾ������
	public int delete(int id) {
		// TODO Auto-generated method stub
		return assessMapper.deleteByPrimaryKey(id);
	}
}
