package com.hotel.luck.controller;


import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.hotelInfo;
import com.hotel.luck.bean.orderInfo;
import com.hotel.luck.bean.privilege;
import com.hotel.luck.bean.userInfo;
import com.hotel.luck.service.DateService;
import com.hotel.luck.service.HotelService;
import com.hotel.luck.service.OrderService;
import com.hotel.luck.service.PrivilegeService;
import com.hotel.luck.service.UserInfoService;
import com.hotel.luck.utils.Message;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService ;
	@Autowired
	HotelService hotelService;
	@Autowired
	DateService dateService;
	@Autowired
	PrivilegeService privilegeService;
	@Autowired
	UserInfoService userinfoService;
	
	//预定房间
	@RequestMapping(value="/build")
	@ResponseBody
	public Message addOrder(
			@RequestParam(value="userId",required=false)int userId,
			@RequestParam(value="hotelId",required=false)int hotelId,
			@RequestParam(value="startTime",required=false)String startTime,
			@RequestParam(value="endTime",required=false)String endTime,
			@RequestParam(value="info",required=false)int[] friend
		) throws ParseException {
		
		Date Start = dateService.strToDate(startTime);
		Date End = dateService.strToDate(endTime);
		
		if (startTime == null || endTime == null) {
			return Message.createErr("起止时间为空");
		}
		if (Start.compareTo(End)>0) {
			return Message.createErr("开始时间大于结束时间");
		}
		
		//int day = dateService.daysOfTwo(startTime, endTime);
		Calendar aCalendar = Calendar.getInstance();
	    aCalendar.setTime(Start);
	    int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
	    aCalendar.setTime(End);
	    int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
	    int day = day2 - day1;
		
	    orderInfo orderinfo=new orderInfo();
		orderinfo.setUserId(userId);
		orderinfo.setHotelId(hotelId);
		orderinfo.setStartTime(Start);
		orderinfo.setEndTime(End);
		String info = "";
		if (friend!=null) {
			for (int i=0;i<friend.length;i++) {
				if (i!=friend.length-1) info = info + String.valueOf(friend[i]) + ";";
				else info = info + String.valueOf(friend[i]);
			}
			orderinfo.setFriend(info);
		}
		else {
			orderinfo.setFriend("-1");
		}
	    
	    hotelInfo hotelinfo = hotelService.selectHotel(hotelId);
	    BigDecimal price = hotelinfo.getPrice();
		BigDecimal Price = price.multiply(new BigDecimal(day));
		orderinfo.setPrice(Price);
		int fg = orderService.insert(orderinfo);
		if (fg==0) return Message.createSuc("添加订单失败");
		
		//添加入住人权限
		List <orderInfo> order = new ArrayList<orderInfo>();
		order = orderService.selectAllOrder();
		int orderId = order.get(order.size()-1).getOrderId();
		privilege privilegeinfo=new privilege();
		privilegeinfo.setOrderId(orderId);
		privilegeinfo.setUserId(userId);
		privilegeinfo.setHotelId(hotelId);
		privilegeinfo.setStartTime(Start);
		privilegeinfo.setEndTime(End);
		privilegeService.insert(privilegeinfo);
		
		if (friend == null) {
			return Message.createSuc("预定成功");
		}
		for (int i=0;i<friend.length;i++) {
			privilegeinfo.setOrderId(orderId);
			privilegeinfo.setUserId(friend[i]);
			privilegeinfo.setHotelId(hotelId);
			privilegeinfo.setStartTime(Start);
			privilegeinfo.setEndTime(End);
			privilegeService.insert(privilegeinfo);
		}
		
		return Message.createSuc("预定成功");
	}
	
	//查看我的订单
	@RequestMapping(value="/order")
	@ResponseBody
	public Message selectUser(
			@RequestParam(value="userId",required=false)int id,
			@RequestParam(value="curr",required=false)int curr
		) {
		List<orderInfo> orderinfo = orderService.selectUser(id);
		if (orderinfo==null) {
			return Message.createErr("无订单");
		}
		
		List<orderInfo> order = new ArrayList<orderInfo>();
		int len = orderinfo.size();
		List<userInfo>[] user = new List[100];
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("curr", curr);
		data.put("all", len);
		//一页五条
		for (int i=(curr-1)*5;i<curr*5;i++) {
			if (i>=len) break;
			user[i] = new ArrayList<userInfo>();
			
			order.add(orderinfo.get(i));
			String str = orderinfo.get(i).getFriend();
			//System.out.println(str);
			if (str=="-1") continue;
			String[] friend = str.split(";");
			//System.out.println(friend.length);
			int Friend;
			for (int j=0;j<friend.length;j++) {
				//System.out.println(friend[j]);
				Friend = Integer.parseInt(friend[j]);
				user[i].add(userinfoService.select(Friend));
			}
		}
		data.put("user", user);
		data.put("info", order);
		return Message.createSuc(data);
	}
	
	//查看订单详情
	@RequestMapping(value="/order/detail")
	@ResponseBody
	public Message selectOrder(
			@RequestParam(value="orderId",required=false) int orderId
		) {
		orderInfo orderinfo = orderService.selectOrder(orderId);
		if (orderinfo==null) {
			return Message.createErr("无对应订单");
		}
		List<userInfo> user = new ArrayList<userInfo>();
		Map<String,Object> data = new HashMap<String,Object>();
		
		String str = orderinfo.getFriend();
		String[] friend = str.split(";");
		int Friend;
		for (int j=0;j<friend.length;j++) {
			Friend = Integer.parseInt(friend[j]);
			user.add(userinfoService.select(Friend));
		}
		data.put("user", user);
		data.put("info", orderinfo);
		return Message.createSuc(data);
	}
	
	//删除订单
	@RequestMapping(value="/order/del")
	@ResponseBody
	public Message deleteOrder(
			@RequestParam(value="orderId",required=false)int orderid,
			@RequestParam(value="userId",required=false)int userid
		) {
		int jg = privilegeService.deleteOrder(orderid);
		if (jg==0) {
			return Message.createSuc("删除失败");
		}
		return Message.createSuc(orderService.delete(orderid));
	}
	
	//取消预订
	@RequestMapping(value="/cancel")
	@ResponseBody
	public Message cancelOrder(
			@RequestParam(value="orderId",required=false)int orderid,
			@RequestParam(value="userId",required=false)int userid
		) {
		int jg = privilegeService.deleteOrder(orderid);
		if (jg==0) {
			return Message.createSuc("删除失败");
		}
		return Message.createSuc(orderService.delete(orderid));
	}

}