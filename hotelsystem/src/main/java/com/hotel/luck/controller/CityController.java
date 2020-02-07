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
	
	//���ӳ�����Ϣ
	@RequestMapping(value="/addcity")
	@ResponseBody
	public Message addCity(@RequestParam(value="name",required=false)String name) {
		
		
		cityInfo cityinfo=new cityInfo();
		cityinfo.setName(name);
		return Message.createSuc(cityService.insert(cityinfo));
	}

	//��ѯ���г�����Ϣ
	@RequestMapping(value="/selectcity")
	@ResponseBody
	public Message selectCity() {
		return Message.createSuc(cityService.getAll());
	}
	
	//ɾ��������Ϣ
	@RequestMapping(value="/deletecity")
	@ResponseBody
	public Message deleteCity(@RequestParam(value="cityId",required=false)int id) {
		return Message.createSuc(cityService.delete(id));
	}
}