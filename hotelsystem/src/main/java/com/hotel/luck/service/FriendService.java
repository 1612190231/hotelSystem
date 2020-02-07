package com.hotel.luck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.friendInfo;
import com.hotel.luck.bean.friendInfoExample;
import com.hotel.luck.dao.friendInfoMapper;
@Service
public class FriendService {
	@Autowired
	friendInfoMapper friendInfoMapper;

	//���ӳ�������Ϣ
	public int insert(friendInfo friendinfo) {
		// TODO Auto-generated method stub
		return friendInfoMapper.insert(friendinfo);
	 
	}
	
	//��ȡ��ס����ϸ��Ϣ
	public friendInfo selectDetail(int FId) {
		// TODO Auto-generated method stub
		return friendInfoMapper.selectByPrimaryKey(FId);
	}
	
	
	//获取入住人列表
	public List<friendInfo> select(int id) {
		// TODO Auto-generated method stub
		friendInfoExample friendinfoexample = new friendInfoExample();
		friendinfoexample.setOrderByClause("user_id asc"); //asc����,desc��������
		friendinfoexample.setDistinct(false); //ȥ���ظ�,true��ѡ���ظ���¼,false��֮
		friendInfoExample.Criteria criteria = friendinfoexample.createCriteria(); //�����Զ����ѯ����
        criteria.andUserIdEqualTo(id);
 
        //�Զ����ѯ�������ܷ��ض�����¼,ʹ��List����
		return friendInfoMapper.selectByExample(friendinfoexample);
	}

	//ɾ��������
	public int delete(int id) {
		// TODO Auto-generated method stub
		return friendInfoMapper.deleteByPrimaryKey(id);
	 }

}
