package com.hotel.luck.controller;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.historyInfo;
import com.hotel.luck.service.HistoryService;
import com.hotel.luck.utils.Message;

@Controller
public class HistoryController {
	/*@Autowired
	HistoryService historyService ;
	
	//增加历史记录
	@RequestMapping(value="/addhistoryinfo")
	@ResponseBody
	public Message addHistory(
			@RequestParam(value="userId",required=false)int userId,
			@RequestParam(value="hotelId",required=false)int hotelId,
			@RequestParam(value="startTime",required=false)Date startTime,
			@RequestParam(value="endTime",required=false)Date endTime,
			@RequestParam(value="price",required=false)BigDecimal price
		) {
		
		historyInfo historyinfo=new historyInfo();
		historyinfo.setUserId(userId);
		historyinfo.setHotelId(hotelId);
		historyinfo.setStartTime(startTime);
		historyinfo.setEndTime(endTime);
		historyinfo.setPrice(price);
		historyinfo.setIsPay(0);
		return Message.createSuc(historyService.insert(historyinfo));
	}

	//查询指定历史记录
	@RequestMapping(value="/selecthistory")
	@ResponseBody
	public Message selectHistory(@RequestParam(value="historyId",required=false)int id) {	

		return Message.createSuc(historyService.selectHistory(id));
	}
	
	//查询房屋历史记录
	@RequestMapping(value="/selecthotelhistory")
	@ResponseBody
	public Message selectHotel(@RequestParam(value="hotelId",required=false)int id) {
			

		return Message.createSuc(historyService.selectHotel(id));
	}

	//查询用户历史记录
	@RequestMapping(value="/selectuserhistory")
	@ResponseBody
	public Message selectUser(@RequestParam(value="userId",required=false)int id) {
			

		return Message.createSuc(historyService.selectUser(id));
	}
	
	//删除历史记录
	@RequestMapping(value="/deletehistory")
	@ResponseBody
	public Message deleteProvince(@RequestParam(value="historyId",required=false)int id) {
		return Message.createSuc(historyService.delete(id));
	}

	//支付历史账单
	@RequestMapping(value="/paymoney")
	@ResponseBody
	public Message payMoney(
			@RequestParam(value="historyId",required=false)int id,
			@RequestParam(value="ispay",required=false)int jg
		) {
		if (jg==1) {
			historyInfo historyinfo=new historyInfo();
			historyinfo = historyService.selectHistory(id);
			historyinfo.setIsPay(1);
			return Message.createSuc(historyService.update(historyinfo));
		}
		else return Message.createSuc("支付失败");
		
	}*/
}