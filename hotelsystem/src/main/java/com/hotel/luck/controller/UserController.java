package com.hotel.luck.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.hotelInfo;
import com.hotel.luck.bean.orderInfo;
import com.hotel.luck.bean.userInfo;
import com.hotel.luck.service.DateService;
import com.hotel.luck.service.HotelService;
import com.hotel.luck.service.OrderService;
import com.hotel.luck.service.UserInfoService;
import com.hotel.luck.utils.Message;

@Controller
public class UserController {
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	HotelService hotelService;
	@Autowired
	OrderService orderService;
	@Autowired
	DateService dateService;

	//登录
	@RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message isTrue(
			@RequestParam(value = "telephone", required = false) String telephone,
			@RequestParam(value = "password", required = false) String password) {

		if (telephone == null || password == null) {
			return Message.createErr("手机或密码为空");
		}
		System.out.println(telephone);
		System.out.println(password);

		List<userInfo> user = userInfoService.getAll();
		System.out.println(user);
		int count = user.size();
		for (int i = 0; i < count; i++) {
			userInfo userInfo1 = user.get(i);
			String tele = userInfo1.getTelephone();
			String pwd = userInfo1.getPassword();
			if (telephone.equals(tele) && password.equals(pwd)) {
				return Message.createSuc("登录成功");
			}
		}
		return Message.createErr("手机或密码错误");
	}

	//注册
	@RequestMapping(value = "/register")
	@ResponseBody
	public Message register(@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "telephone", required = false) String telephone,
			@RequestParam(value = "trueName", required = false) String trueName,
			@RequestParam(value = "sex", required = false) String sex,
			@RequestParam(value = "IDCard", required = false) String IDCard,
			@RequestParam(value = "age", required = false) int age,
			@RequestParam(value = "cardURL", required = false) String cardURL) {

		System.out.println(userName);
		System.out.println(password);
		System.out.println(telephone);
		System.out.println(trueName);

		userInfo userinfo = new userInfo();
		userinfo.setUserName(userName);
		userinfo.setPassword(password);
		userinfo.setTelephone(telephone);
		userinfo.setTrueName(trueName);
		userinfo.setAge(age);
		userinfo.setIsValidate(0);
		userinfo.setCardUrl(cardURL);
		userinfo.setIdCard(IDCard);
		userinfo.setSex(sex);
		
		Date now = new Date();
		userinfo.setRegisterTime(now);

		return Message.createSuc(userInfoService.insert(userinfo));
	}

	//获取收藏夹内容
	@RequestMapping(value = "/collection")
	@ResponseBody
	public Message likeList(@RequestParam(value = "userId", required = false) int userId) {

		userInfo userinfo = userInfoService.select(userId);
		List<hotelInfo> hotelinfo = new ArrayList<hotelInfo>();
		String likeinfo = userinfo.getLikeList();
		String[] str = likeinfo.split(";");
		for (int i = 0; i < str.length; i++) {
			int hotelId = Integer.parseInt(str[i]);
			hotelinfo.add(hotelService.selectHotel(hotelId));
		}

		if (hotelinfo.isEmpty()) {
			return Message.createErr("收藏夹信息为空");
		}

		return Message.createSuc(hotelinfo);
	}

	//注销
	@RequestMapping(value = "/logout", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message logout(@RequestParam(value = "userId", required = false) int userid) {

		return Message.createSuc("注销成功");
	}
}
