package com.hotel.luck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.luck.bean.R1;
import com.hotel.luck.bean.R2;
import com.hotel.luck.dao.R1Mapper;
import com.hotel.luck.dao.R2Mapper;

@Service
public class PhotoService {
	@Autowired
	R1Mapper r1Mapper;
	@Autowired
	R2Mapper r2Mapper;
	
	public List<R1> getAll(){
		
		return r1Mapper.selectByExample(null);
	}
	
	public List<R2> getR2All(){
		return r2Mapper.selectByExample(null);
	}
}
