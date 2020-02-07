package com.hotel.luck.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.cityInfo;
import com.hotel.luck.service.CityService;
import com.hotel.luck.utils.Message;

@Controller
public class CityController {
	@Autowired
	CityService cityService ;
	
	//增加城市信息
	@RequestMapping(value="/addcity")
	@ResponseBody
	public Message addCity(@RequestParam(value="name",required=false)String name) {
		
		
		cityInfo cityinfo=new cityInfo();
		cityinfo.setName(name);
		return Message.createSuc(cityService.insert(cityinfo));
	}

	//查询所有城市信息
	@RequestMapping(value="/selectcity")
	@ResponseBody
	public Message selectCity() {
		return Message.createSuc(cityService.getAll());
	}
	
	//删除城市信息
	@RequestMapping(value="/deletecity")
	@ResponseBody
	public Message deleteCity(@RequestParam(value="cityId",required=false)int id) {
		return Message.createSuc(cityService.delete(id));
	}
}