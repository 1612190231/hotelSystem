package com.hotel.luck.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.assess;
import com.hotel.luck.service.AssessService;
import com.hotel.luck.service.HotelService;
import com.hotel.luck.utils.Message;

@Controller
public class AssessController {
	@Autowired
	AssessService assessService ;
	HotelService hotelService ;
	
	//增加评价
	@RequestMapping(value="/addassess")
	@ResponseBody
	public Message insertAssess(
			@RequestParam(value="hotelId",required=false)int hotelId,
			@RequestParam(value="userId",required=false)int userId,
			@RequestParam(value="userName",required=false)String userName,
			@RequestParam(value="assessment",required=false)String assessment,
			@RequestParam(value="star",required=false)int star					
			) {
		
		
		assess assessinfo=new assess();
		assessinfo.setHotelId(hotelId);
		assessinfo.setUserId(userId);
		assessinfo.setUserName(userName);
		assessinfo.setAssessment(assessment);
		assessinfo.setStar(star);
		
		return Message.createSuc(assessService.insertAssess(assessinfo));
	}
	
	//查房屋评价
	@RequestMapping(value="/selecthotelassess")
	@ResponseBody
	public Message selectHotel(@RequestParam(value="hotelId",required=false)int id) {
		

		return Message.createSuc(assessService.selectHotel(id));
	}

	//查用户评价
	@RequestMapping(value="/selectuserassess")
	@ResponseBody
	public Message selectUser(@RequestParam(value="userId",required=false)int id) {
		

		return Message.createSuc(assessService.selectUser(id));
	}

	//删除评价
	@RequestMapping(value="/deleteassess")
	@ResponseBody
	public Message delete(@RequestParam(value="assessId",required=false)int id) {
		

		return Message.createSuc(assessService.delete(id));
	}
}