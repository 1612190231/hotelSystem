package com.hotel.luck.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.friendInfo;
import com.hotel.luck.bean.userInfo;
import com.hotel.luck.service.FriendService;
import com.hotel.luck.service.UserInfoService;
import com.hotel.luck.utils.Message;

@Controller
public class FriendController {
	@Autowired
	FriendService friendService;
	@Autowired
	UserInfoService userinfoService;

	//添加入住人
	@RequestMapping(value = "/friend/add")
	@ResponseBody
	public Message insertFriend(@RequestParam(value = "userId", required = false) int userId,
			@RequestParam(value = "friendId", required = false) int friendId) {

		List<userInfo> userinfo = userinfoService.getAll();
		int user;
		int fg_1=0,fg_2=0;
		for (int i=0;i<userinfo.size();i++) {
			user = userinfo.get(i).getUserId();
			if (user==userId) fg_1=1;
			if (user==friendId) fg_2=1;
		}
		if (fg_1 == 0 || fg_2 == 0) {
			return Message.createErr("用户或入住人输入有误");
		}
		userInfo friend = userinfoService.select(friendId);
		if (friend.getIsValidate()!=1) {
			return Message.createErr("入住人未通过审核或账户已注销");
		}
		
		friendInfo friendinfo = new friendInfo();
		friendinfo.setUserId(userId);
		friendinfo.setFriendId(friendId);
		return Message.createSuc(friendService.insert(friendinfo));
	}

	//获取入住人详细信息
	@RequestMapping(value = "/friend/detail")
	@ResponseBody
	public Message selectDetail(@RequestParam(value = "userId", required = false) int userId,
			@RequestParam(value = "FId", required = false) int FId) {
		friendInfo friendinfo = friendService.selectDetail(FId);
		if (friendinfo.getUserId()!=userId) {
			return Message.createErr("无对应的入住人信息");
		}
		int friendId = friendinfo.getFriendId();
		userInfo user = userinfoService.select(friendId);
		return Message.createSuc(user);
	}

	//获取入住人列表
	@RequestMapping(value = "/friend")
	@ResponseBody
	public Message selectList(@RequestParam(value = "userId", required = false) int userId) {

		List<friendInfo> friend = friendService.select(userId);
		List<userInfo> user = new ArrayList<userInfo>();
		for (int i=0;i<friend.size();i++) {
			user.add(userinfoService.select(friend.get(i).getFriendId()));
		}
		
		return Message.createSuc(user);
	}

	//修改入住人信息(废弃)
	@RequestMapping(value = "/friend/chg")
	@ResponseBody
	public Message updateUser(@RequestParam(value = "userId", required = false) int userId,
			@RequestParam(value = "telephone", required = false) String telephone,
			@RequestParam(value = "IDCard", required = false) String IDCard,
			@RequestParam(value = "sex", required = false) String sex,
			@RequestParam(value = "age", required = false) int age,
			@RequestParam(value = "trueName", required = false) String trueName) {

		userInfo userinfo = userinfoService.select(userId);
		userinfo.setUserId(userId);
		userinfo.setTelephone(telephone);
		userinfo.setIdCard(IDCard);
		userinfo.setAge(age);
		userinfo.setTrueName(trueName);
		userinfo.setSex(sex);
		return Message.createSuc(userinfoService.update(userinfo));
	}

	//删除入住人
	@RequestMapping(value = "/friend/delete")
	@ResponseBody
	public Message deleteProvince(@RequestParam(value = "FId", required = false) int id) {
		return Message.createSuc(friendService.delete(id));
	}

}