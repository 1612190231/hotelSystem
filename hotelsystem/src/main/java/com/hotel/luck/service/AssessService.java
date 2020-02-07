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

	//增加评价
	public int insertAssess(assess assess) {
		// TODO Auto-generated method stub
		return assessMapper.insert(assess);
	}
	
	//查询房屋评价
	public List<assess> selectHotel(int id) {
		// TODO Auto-generated method stub
		assessExample assessexample = new assessExample();
		assessexample.setOrderByClause("hotelId asc"); //asc升序,desc降序排列
		assessexample.setDistinct(false); //去除重复,true是选择不重复记录,false反之
		assessExample.Criteria criteria = assessexample.createCriteria(); //构造自定义查询条件
        criteria.andUserIdEqualTo(id);
 
        //自定义查询条件可能返回多条记录,使用List接收
		return assessMapper.selectByExample(assessexample);
	}
	
	//查询用户评价
	public List<assess> selectUser(int id) {
		// TODO Auto-generated method stub
		assessExample assessexample = new assessExample();
		assessexample.setOrderByClause("userId asc"); //asc升序,desc降序排列
		assessexample.setDistinct(false); //去除重复,true是选择不重复记录,false反之
		assessExample.Criteria criteria = assessexample.createCriteria(); //构造自定义查询条件
        criteria.andUserIdEqualTo(id);
 
        //自定义查询条件可能返回多条记录,使用List接收
		return assessMapper.selectByExample(assessexample);
	}

	//删除评价
	public int delete(int id) {
		// TODO Auto-generated method stub
		return assessMapper.deleteByPrimaryKey(id);
	}
}
