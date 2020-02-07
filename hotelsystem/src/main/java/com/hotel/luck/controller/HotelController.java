package com.hotel.luck.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.hotelInfo;
import com.hotel.luck.bean.orderInfo;
import com.hotel.luck.bean.sensorUsing;
import com.hotel.luck.bean.userInfo;
import com.hotel.luck.service.DateService;
import com.hotel.luck.service.HotelService;
import com.hotel.luck.service.SensorService;
import com.hotel.luck.service.UserInfoService;
import com.hotel.luck.service.LockService;
import com.hotel.luck.service.OrderService;
import com.hotel.luck.utils.Message;

@Controller
public class HotelController {
	@Autowired
	HotelService hotelService;
	@Autowired
	SensorService SensorService;
	@Autowired
	LockService LockService;
	@Autowired
	OrderService orderService;
	@Autowired
	DateService dateService;
	@Autowired
	UserInfoService userInfoService;

	//根据分页获取所有房间
	@RequestMapping(value = "/room")
	@ResponseBody
	public Message getOrder() {

		List<hotelInfo> hotelinfo = hotelService.getAll();
		int len = hotelinfo.size();
		if (len == 0) {
			return Message.createSuc("房间信息为空");
		}
		Map<String, Object>[] data = new IdentityHashMap[20];
		int[] curr = new int[10];
		//一页五条
		int cnt = 0;
		int i=0,j;
		while (i < len) {
			List<hotelInfo> hotel = new ArrayList<hotelInfo>();
			curr[cnt] = cnt + 1;
			for (i = cnt * 5; i < (cnt+1) * 5; i++) {
				if (i >= len)
					break;
				hotel.add(hotelinfo.get(i));
			}
			if (hotel.isEmpty())
				break;
			data[cnt] = new IdentityHashMap<String, Object>();
			data[cnt].put("curr", curr[cnt]);
			data[cnt].put("all", len);
			data[cnt].put("info", hotel);
			/*System.out.println("--------------");
			for (j=0;j<hotel.size();j++) {
				System.out.println(hotel.get(j).getHotelId());
			}*/
			cnt++;
		}
		return Message.createSuc(data);
	}
	
	//更新房间星级信息
	@RequestMapping(value = "/room/star/update")
	@ResponseBody
	public Message updateHotelstar(@RequestParam(value = "hotelId", required = false) int hotelid,
			@RequestParam(value = "star", required = false) int star) {
		hotelInfo hotelinfo = new hotelInfo();
		hotelinfo = hotelService.selectHotel(hotelid);
		int Star = hotelinfo.getStar();
		int count = hotelinfo.getUseCount();
		int sum = Star * count;
		count += 1;
		Star = (sum + star) / count;
		hotelinfo.setUseCount(count);
		hotelinfo.setStar(Star);
		return Message.createSuc(hotelService.update(hotelinfo));
	}

	//收藏或取消收藏房间
	@RequestMapping(value = "/room/like")
	@ResponseBody
	public Message likeRoom(@RequestParam(value = "hotelId", required = false) int hotelId,
			@RequestParam(value = "userId", required = false) int userId,
			@RequestParam(value = "isLike", required = false) boolean islike) {
		
		userInfo userinfo = userInfoService.select(userId);
		String likeinfo = userinfo.getLikeList();
		if (islike==true) {
			likeinfo = likeinfo + hotelId + ";";
			userinfo.setLikeList(likeinfo);
		}
		else {
			String last = "";
			String[] like = likeinfo.split(";");
			for (int i=0;i<like.length;i++) {
				int li = Integer.valueOf(like[i]);
				if (li != hotelId) {
					last = last + like[i] + ";";
				}
			}
			userinfo.setLikeList(last);
		}

		return Message.createSuc(userInfoService.update(userinfo));
	}

	//查看房间详情
	@RequestMapping(value = "/room/detail")
	@ResponseBody
	public Message selecHotel(@RequestParam(value = "hotelId", required = false) int id) {

		return Message.createSuc(hotelService.selectHotel(id));
	}

	//根据居住时间查询房间列表
	@RequestMapping(value = "/room/time", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message selectByTime(
			@RequestParam(value = "startTime", required = false) String starttime,
			@RequestParam(value = "endTime", required = false) String endtime) throws ParseException {

		Date Start = dateService.strToDate(starttime);
		Date End = dateService.strToDate(endtime);
		
		List<hotelInfo> hotelinfo = hotelService.getAll();
		List<hotelInfo> lastinfo = new ArrayList<hotelInfo>();
		int i, j;
		for (i = 0; i < hotelinfo.size(); i++) {
			int hotelid = hotelinfo.get(i).getHotelId();
			List<orderInfo> orderinfo = orderService.selectHotel(hotelid);
			for (j = 0; j < orderinfo.size(); j++) {
				Date start = orderinfo.get(j).getStartTime();
				Date end = orderinfo.get(j).getEndTime();

				int day1 = dateService.daysOfTwo(start, Start);
				int day2 = dateService.daysOfTwo(end, Start);
				int day3 = dateService.daysOfTwo(start, End);
				int day4 = dateService.daysOfTwo(end, End);

				if (day1 >= 0 && day2 < 0)
					break;
				if (day3 > 0 && day4 <= 0)
					break;
			}
			if (j == orderinfo.size()) {
				lastinfo.add(hotelinfo.get(i));
			}
		}

		Map<String, Object>[] data = new IdentityHashMap[20];
		int[] curr = new int[10];
		int len = lastinfo.size();
		
		//一页五条
		int cnt = 0;
		i=0;
		while (i < len) {
			List<hotelInfo> hotel = new ArrayList<hotelInfo>();
			curr[cnt] = cnt + 1;
			for (i = cnt * 5; i < (cnt+1) * 5; i++) {
				if (i >= len)
					break;
				hotel.add(hotelinfo.get(i));
			}
			if (hotel.isEmpty())
				break;
			data[cnt] = new IdentityHashMap<String, Object>();
			data[cnt].put("curr", curr[cnt]);
			data[cnt].put("all", len);
			data[cnt].put("info", hotel);
			cnt++;
		}

		return Message.createSuc(data);
	}

	//根据关键字搜索房间列表
	@RequestMapping(value = "/room/search", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message selectLike(@RequestParam(value = "key", required = false) String key) throws ParseException {

		List<hotelInfo> hotelinfo = hotelService.selectLike(key);
		Map<String, Object>[] data = new IdentityHashMap[20];
		int i;
		int[] curr = new int[10];
		int len = hotelinfo.size();
		
		//一页五条
		int cnt = 0;
		i=0;
		while (i < len) {
			List<hotelInfo> hotel = new ArrayList<hotelInfo>();
			curr[cnt] = cnt + 1;
			for (i = cnt * 5; i < (cnt+1) * 5; i++) {
				if (i >= len)
					break;
				hotel.add(hotelinfo.get(i));
			}
			if (hotel.isEmpty())
				break;
			data[cnt] = new IdentityHashMap<String, Object>();
			data[cnt].put("curr", curr[cnt]);
			data[cnt].put("all", len);
			data[cnt].put("info", hotel);
			cnt++;
		}

		return Message.createSuc(data);
	}
}