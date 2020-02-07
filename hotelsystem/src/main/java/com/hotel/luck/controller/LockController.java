package com.hotel.luck.controller;


import java.util.Date;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.hotelInfo;
import com.hotel.luck.bean.lockInfo;
import com.hotel.luck.bean.lockUsing;
import com.hotel.luck.bean.privilege;
import com.hotel.luck.bean.userInfo;
import com.hotel.luck.service.HotelService;
import com.hotel.luck.service.LockService;
import com.hotel.luck.service.PrivilegeService;
import com.hotel.luck.service.UserInfoService;
import com.hotel.luck.utils.Message;
import com.hotel.luck.utils.ServerMQTTUtil;

@Controller
public class LockController {
	@Autowired
	LockService lockService;
	@Autowired
	HotelService hotelService;
	@Autowired
	PrivilegeService privilegeService;
	@Autowired
	UserInfoService userInfoService;
	
	//����������Ϣ
	@RequestMapping(value="/lock/add",method = RequestMethod.POST)
	@ResponseBody
	public Message addLockinfo(@RequestParam(value="hotelId",required=false)int hotelid) throws ParseException, MqttException {
		
		hotelInfo hotelinfo = new hotelInfo();
		hotelinfo = hotelService.selectHotel(hotelid);
		double lon = hotelinfo.getLongitude();
		double lat = hotelinfo.getLatitude();
		String address = hotelinfo.getAddress();
		
		lockInfo lockinfo=new lockInfo();
		lockinfo.setHotelId(hotelid);
		lockinfo.setLongitude(lon);
		lockinfo.setLatitude(lat);
		lockinfo.setLockStatus(1);
		lockinfo.setAddress(address);
		
		return Message.createSuc(lockService.insertinfo(lockinfo));
	}

	//��ѯ����������Ϣ
	@RequestMapping(value="/lock/select")
	@ResponseBody
	public Message selectLockinfo() {
		return Message.createSuc(lockService.getAllInfo());
	}
	
	//������������Ϣ
	@RequestMapping(value="/lock/update")
	@ResponseBody
	public Message updateLockinfo(
			@RequestParam(value="lockId",required=false)int lockId,
			@RequestParam(value="lockStatus",required=false)int isgood) {
		lockInfo lockinfo = new lockInfo();
		lockinfo = lockService.selectinfo(lockId);
		lockinfo.setLockStatus(isgood);
		return Message.createSuc(lockService.updateinfo(lockinfo));
	}
	
	//扫码开门
	@RequestMapping(value="/door/open")
	@ResponseBody
	public Message judgePrivilege(
			@RequestParam(value="hotelId",required=false)int hotelid,
			@RequestParam(value="userId",required=false)int userid) throws UnsupportedEncodingException, MqttException, InterruptedException {
	
		List<privilege> privilegeinfo = new ArrayList<privilege>();
		lockInfo lockinfo = new lockInfo();
		lockUsing lockusing = new lockUsing();
		privilegeinfo = privilegeService.selectHotel(hotelid);
		int i;
		int num=1;
		System.out.println(privilegeinfo.size());
		for (i=0;i<privilegeinfo.size();i++) {
			System.out.println(num);
			num++;
			int user = privilegeinfo.get(i).getUserId();
			System.out.println(user);
			System.out.println(userid);
			if (user==userid) {
				
				String isopen = "opentest3";
	            System.out.println(isopen);
	            
	            //连接mqtt
	            MqttMessage mqttMessage = new MqttMessage();
	            mqttMessage.setQos(0);
	            mqttMessage.setRetained(true);
	            mqttMessage.setPayload(isopen.getBytes("UTF-8"));
	            
	            //组装消息体
	            String hotelId = "hotel" + hotelid +"/Lock";
	            String topic = hotelId;
	            ServerMQTTUtil serverMQTTUtil = new ServerMQTTUtil(topic);
	            serverMQTTUtil.publish(mqttMessage);
	            System.out.println(mqttMessage.isRetained() + "------ratained״̬");
				
				//添加开门信息
				lockinfo = lockService.selectinfo(hotelid);
				userInfo userinfo = userInfoService.select(userid);
				String userName = userinfo.getUserName();
				Date time = new Date();
				lockusing.setTime(time);
				lockusing.setUserId(userid);
				lockusing.setHotelId(hotelid);
				lockusing.setUserName(userName);
				lockService.insertmsg(lockusing);
				
				return Message.createSuc(true);
			}
		}
		
		return Message.createErr("开门失败");
	}
	
	//ɾ��������Ϣ
	@RequestMapping(value="/lock/delete")
	@ResponseBody
	public Message deleteLockinfo(@RequestParam(value="lockId",required=false)int id) {
		return Message.createSuc(lockService.deleteinfo(id));
	}
}