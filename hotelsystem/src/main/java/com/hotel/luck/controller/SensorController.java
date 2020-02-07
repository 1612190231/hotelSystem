package com.hotel.luck.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.hotelInfo;
import com.hotel.luck.bean.sensorInfo;
import com.hotel.luck.service.HotelService;
import com.hotel.luck.service.PrivilegeService;
import com.hotel.luck.service.SensorService;
import com.hotel.luck.utils.Message;
import com.hotel.luck.utils.runTaskUtil;

@Controller
public class SensorController {
	@Autowired
	SensorService sensorService;
	@Autowired
	HotelService hotelService;
	@Autowired
	PrivilegeService privilegeService;
	
	//增加传感器信息
	@RequestMapping(value="/sensor/add")
	@ResponseBody
	public Message addSensorinfo(@RequestParam(value="hotelId",required=false)int hotelid) throws ParseException {
		
		hotelInfo hotelinfo = new hotelInfo();
		hotelinfo = hotelService.selectHotel(hotelid);
		double lon = hotelinfo.getLongitude();
		double lat = hotelinfo.getLatitude();
		
		sensorInfo sensorinfo=new sensorInfo();
		sensorinfo.setHotelId(hotelid);
		sensorinfo.setLongitude(lon);
		sensorinfo.setLatitude(lat);
		sensorinfo.setSensorStatus(1);
		
		//订阅mqtt消息
		String hotelId = "hotel" + hotelid + "/Sensor";
		runTaskUtil run = new runTaskUtil();
		run.runTask(hotelid,hotelId,sensorService);
		
		return Message.createSuc(sensorService.insertinfo(sensorinfo));
	}

	//查询所有传感器信息
	@RequestMapping(value="/sensor/select")
	@ResponseBody
	public Message selectSensorinfo() {
		return Message.createSuc(sensorService.getAllInfo());
	}
	
	//更新传感器损坏信息
	@RequestMapping(value="/sensor/update")
	@ResponseBody
	public Message updateSensorinfo(
			@RequestParam(value="sensorId",required=false)int lockId,
			@RequestParam(value="sensorStatus",required=false)int isgood) {
		sensorInfo sensorinfo = new sensorInfo();
		sensorinfo = sensorService.selectinfo(lockId);
		sensorinfo.setSensorStatus(isgood);
		return Message.createSuc(sensorService.updateinfo(sensorinfo));
	}
	
	//删除传感器信息
	@RequestMapping(value="/sensor/delete")
	@ResponseBody
	public Message deleteSensorinfo(@RequestParam(value="sensorId",required=false)int id) {
		return Message.createSuc(sensorService.deleteinfo(id));
	}
}
