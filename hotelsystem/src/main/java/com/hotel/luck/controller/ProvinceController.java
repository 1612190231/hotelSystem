package com.hotel.luck.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.provinceInfo;
import com.hotel.luck.service.ProvinceService;
import com.hotel.luck.utils.Message;

@Controller
public class ProvinceController {
	@Autowired
	ProvinceService provinceService ;
	
	//增加省会信息
	@RequestMapping(value="/province/add")
	@ResponseBody
	public Message addProvince(@RequestParam(value="name",required=false)String name) {
		
		
		provinceInfo provinceinfo=new provinceInfo();
		provinceinfo.setName(name);
		return Message.createSuc(provinceService.insert(provinceinfo));
	}

	//查询省会信息
	@RequestMapping(value="/selectprovince")
	@ResponseBody
	public Message selectProvince() {
		return Message.createSuc(provinceService.getAll());
	}

	//删除省会信息
	@RequestMapping(value="/deleteprovince")
	@ResponseBody
	public Message deleteProvince(@RequestParam(value="provinceId",required=false)int id) {
		return Message.createSuc(provinceService.delete(id));
	}

}