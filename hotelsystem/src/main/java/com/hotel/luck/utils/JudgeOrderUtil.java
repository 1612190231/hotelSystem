package com.hotel.luck.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.luck.bean.historyInfo;
import com.hotel.luck.bean.orderInfo;
import com.hotel.luck.service.DateService;
import com.hotel.luck.service.HistoryService;
import com.hotel.luck.service.HotelService;
import com.hotel.luck.service.OrderService;
import com.hotel.luck.service.PrivilegeService;

public class JudgeOrderUtil {
	@Autowired
	OrderService orderService;
	@Autowired
	PrivilegeService privilegeService;
	@Autowired
	HistoryService historyService;
	@Autowired
	HotelService hotelService;
	@Autowired
	DateService dateService;
	
	//定时查询、更新订单情况
	public void execute() throws ParseException{
		List<orderInfo> orderinfo = new ArrayList<orderInfo> ();
		orderinfo = orderService.selectAllOrder();
		
		int i;
		Date date = new Date();
		System.out.println(date);
		for (i=0;i<orderinfo.size();i++) {
			Date startTime=orderinfo.get(i).getStartTime();
			Date endTime=orderinfo.get(i).getEndTime();
			BigDecimal price = orderinfo.get(i).getPrice();
			if (dateService.daysOfTwo(endTime, date) < 0) { //删除权限
					
					
				//添加历史订单
				historyInfo historyinfo=new historyInfo();
				historyinfo.setUserId(orderinfo.get(i).getUserId());
				historyinfo.setHotelId(orderinfo.get(i).getHotelId());
				historyinfo.setStartTime(startTime);
				historyinfo.setEndTime(endTime);
				historyinfo.setIsPay(0);
				historyinfo.setPrice(price);
				historyService.insert(historyinfo);//增加历史订单
				privilegeService.delete(orderinfo.get(i).getOrderId());//删除出入权限
				orderService.delete(orderinfo.get(i).getOrderId());//删除订单
					
			}
		}
	}
}
