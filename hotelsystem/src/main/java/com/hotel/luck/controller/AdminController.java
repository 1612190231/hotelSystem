package com.hotel.luck.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hotel.luck.bean.adminInfo;
import com.hotel.luck.bean.hotelInfo;
import com.hotel.luck.bean.lockUsing;
import com.hotel.luck.bean.orderInfo;
import com.hotel.luck.bean.sensorUsing;
import com.hotel.luck.bean.userInfo;
import com.hotel.luck.service.AdminService;
import com.hotel.luck.service.CityService;
import com.hotel.luck.service.DateService;
import com.hotel.luck.service.FriendService;
import com.hotel.luck.service.HotelService;
import com.hotel.luck.service.LockService;
import com.hotel.luck.service.OrderService;
import com.hotel.luck.service.ProvinceService;
import com.hotel.luck.service.SensorService;
import com.hotel.luck.service.UserInfoService;
import com.hotel.luck.utils.Message;
import com.hotel.luck.utils.Talk;

import net.sf.json.JSONObject;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	UserInfoService userinfoService;
	@Autowired
	OrderService orderService;
	@Autowired
	HotelService hotelService;
	@Autowired
	CityService cityService;
	@Autowired
	ProvinceService provinceService;
	@Autowired
	LockService lockService;
	@Autowired
	FriendService friendService;
	@Autowired
	SensorService sensorService;
	@Autowired
	DateService dateService;

	//登录后台
	@RequestMapping(value = "/admin/login", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Message isTrue(@RequestParam(value = "account", required = false) String account,
			@RequestParam(value = "password", required = false) String password) {

		if (account == null || password == null) {
			return Message.createErr("用户名或密码为空");
		}
		System.out.println(account);
		System.out.println(password);

		List<adminInfo> user = adminService.getAll();
		System.out.println(user);
		int count = user.size();
		for (int i = 0; i < count; i++) {
			adminInfo adminInfo = user.get(i);
			String a = adminInfo.getAccount();
			String b = adminInfo.getPassword();
			if (account.equals(a) && password.equals(b)) {
				return Message.createSuc(1);
			}
		}
		return Message.createErr("用户名或密码错误");
	}

	//根据分页获取用户列表
	@RequestMapping(value = "/admin/user")
	@ResponseBody
	public Message getUser(@RequestParam(value = "curr", required = false) int curr) {

		List<userInfo> userinfo = userinfoService.getAll();
		List<userInfo> user = new ArrayList<userInfo>();
		int len = userinfo.size();
		if (len == 0) {
			return Message.createErr("无用户数据");
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("curr", curr);
		data.put("all", len);
		//十条数据一页
		for (int i = (curr - 1) * 10; i < curr * 10; i++) {
			if (i == len)
				break;
			user.add(userinfo.get(i));
		}
		data.put("info", user);
		return Message.createSuc(data);
	}

	//修改用户当前状态״̬
	@RequestMapping(value = "/admin/user/chgStatus")
	@ResponseBody
	public Message updateValidate(@RequestParam(value = "userId", required = false) int id,
			@RequestParam(value = "isValidate", required = false) int is) {

		userInfo userinfo = userinfoService.select(id);
		userinfo.setIsValidate(is);
		return Message.createSuc(userinfoService.update(userinfo));
	}

	//根据分页获取订单列表
	@RequestMapping(value = "/admin/order")
	@ResponseBody
	public Message getOrder(@RequestParam(value = "curr", required = false) int curr) {

		List<orderInfo> orderinfo = orderService.selectAllOrder();
		List<orderInfo> order = new ArrayList<orderInfo>();
		int len = orderinfo.size();
		if (len == 0) {
			return Message.createErr("订单数据为空");
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("curr", curr);
		data.put("all", len);
		//十条数据一页
		for (int i = (curr - 1) * 10; i < curr * 10; i++) {
			if (i == len)
				break;
			order.add(orderinfo.get(i));
		}
		data.put("orderinfo", order);
		return Message.createSuc(data);
	}

	//获取订单详情
	@RequestMapping(value = "/admin/order/detail")
	@ResponseBody
	public Message selectOrder(@RequestParam(value = "orderId", required = false) int id) {

		//获取订单信息
		orderInfo orderinfo = new orderInfo();
		orderinfo = orderService.selectOrder(id);
		int hotelid = orderinfo.getHotelId();

		//获取房间信息
		hotelInfo hotelinfo = new hotelInfo();
		hotelinfo = hotelService.selectHotel(hotelid);
		List<userInfo> user = new ArrayList<userInfo>();

		//获取入住人信息
		String str = orderinfo.getFriend();
		String[] friend = str.split(";");
		int[] Friend = new int[100];
		for (int j = 0; j < friend.length; j++) {
			Friend[j] = Integer.parseInt(friend[j]);
			user.add(userinfoService.select(Friend[j]));
		}

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user", user);
		data.put("hotelinfo", hotelinfo);
		data.put("orderinfo", orderinfo);
		return Message.createSuc(data);
	}

	//根据注册时间和用户状态筛选用户
	@RequestMapping(value = "/admin/user/select")
	@ResponseBody
	public Message getUserByTime(
			@RequestParam(value = "isValidate", required = false) int isValidate,
			@RequestParam(value = "registerTime", required = false) String registerTime
	) throws ParseException {
		
		//字符串转Date
		Date time = dateService.strToDate(registerTime);
		
		//获取用户信息
		List<userInfo> userinfo = userinfoService.getAll();
		List<userInfo> lastinfo = new ArrayList<userInfo>();
		int i;
		for (i = 0; i < userinfo.size(); i++) {
			if (userinfo.get(i).getIsValidate() == isValidate && userinfo.get(i).getRegisterTime().compareTo(time)==0) {
				lastinfo.add(userinfo.get(i));
			}
		}

		if (lastinfo.isEmpty()) {
			return Message.createErr("用户信息为空");
		}
		
		Map<String, Object>[] data = new IdentityHashMap[20];
		int[] curr = new int[10];
		int len = lastinfo.size();
		//十条数据一页
		int cnt = 0;
		i = 0;
		while (i < len) {
			List<userInfo> user = new ArrayList<userInfo>();
			curr[cnt]=cnt + 1;
			for (i = cnt * 10; i < (cnt+1) * 10; i++) {
				if (i >= len)
					break;
				user.add(lastinfo.get(i));
			}
			if (user.isEmpty())
				break;
			data[cnt] = new IdentityHashMap<String, Object>();
			data[cnt].put("curr", curr[cnt]);
			data[cnt].put("all", len);
			data[cnt].put("info", user);
			cnt++;
		}

		return Message.createSuc(data);
	}

	//根据省市价格筛选房间列表
	@RequestMapping(value = "/admin/room/select")
	@ResponseBody
	public Message getRoomByCity(
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "province", required = false) String province,
			@RequestParam(value = "money", required = false) String money) {
		//获取房间信息
		List<hotelInfo> hotelinfo = hotelService.getAll();
		List<hotelInfo> lastinfo = new ArrayList<hotelInfo>();
		int i, j;
		for (i = 0; i < hotelinfo.size(); i++) {
			if (hotelinfo.get(i).getCity().equals(city) && hotelinfo.get(i).getProvince().equals(province)) {
				String[] Money = money.split("-");
				int minM = Integer.valueOf(Money[0]);
				int maxM = Integer.valueOf(Money[1]);
				BigDecimal price = new BigDecimal(0);
				price = hotelinfo.get(i).getPrice();
				int Price = price.intValue();
				if (minM <= Price && maxM >= Price) {
					lastinfo.add(hotelinfo.get(i));
				}
			}
		}

		if (lastinfo.isEmpty()) {
			return Message.createErr("房间信息为空");
		}
		
		Map<String, Object>[] data = new IdentityHashMap[20];
		int[] curr = new int[10];
		int len = lastinfo.size();
		System.out.println(len);
		//十条数据一页
		int cnt = 0;
		i = 0;
		while (i < len) {
			List<hotelInfo> hotel = new ArrayList<hotelInfo>();
			curr[cnt]=cnt + 1;
			for (i = cnt * 10; i < (cnt+1) * 10; i++) {
				if (i >= len)
					break;
				hotel.add(lastinfo.get(i));
			}
			System.out.println(hotel);
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

	//根据入住时间和离店时间筛选订单
	@RequestMapping(value = "/admin/order/select")
	@ResponseBody
	public Message getOrderByTime(
			@RequestParam(value = "startTime", required = false) String starttime,
			@RequestParam(value = "endTime", required = false) String endtime) throws ParseException {

		Date Start = dateService.strToDate(starttime);
		Date End = dateService.strToDate(endtime);
		System.out.println(Start);
		System.out.println(End);
		
		List<orderInfo> orderinfo = orderService.selectAllOrder();
		List<orderInfo> lastinfo = new ArrayList<orderInfo>();
		int i;
		for (i = 0; i < orderinfo.size(); i++) {
				Date start = orderinfo.get(i).getStartTime();
				Date end = orderinfo.get(i).getEndTime();
				
				if (Start.compareTo(start)<0 && End.compareTo(end)>0)
					lastinfo.add(orderinfo.get(i));
		}
		
		if (lastinfo.isEmpty()) {
			return Message.createErr("符合的订单信息为空");
		}

		Map<String, Object>[] data = new IdentityHashMap[20];
		int[] curr = new int[100];
		int len = lastinfo.size();
		System.out.println(len);
		//十条数据一页
		int cnt = 0;
		i=0;
		while (i < len) {
			List<orderInfo> order = new ArrayList<orderInfo>();
			curr[cnt] = cnt + 1;
			for (i = cnt * 10; i < (cnt+1) * 10; i++) {
				if (i >= len)
					break;
				order.add(lastinfo.get(i));
			}
			if (order.isEmpty())
				break;
			data[cnt] = new IdentityHashMap<String, Object>();
			data[cnt].put("curr", curr[cnt]);
			data[cnt].put("all", len);
			data[cnt].put("info", order);
			cnt++;
		}

		return Message.createSuc(data);
	}

	//根据分页获取房间列表
	@RequestMapping(value = "/admin/room")
	@ResponseBody
	public Message getHotel(@RequestParam(value = "curr", required = false) int curr) {

		List<hotelInfo> hotelinfo = hotelService.getAll();
		List<hotelInfo> hotel = new ArrayList<hotelInfo>();
		int len = hotelinfo.size();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("curr", curr);
		data.put("all", len);
		
		//十条数据一页
		for (int i = (curr - 1) * 10; i < curr * 10; i++) {
			if (i == len)
				break;
			hotel.add(hotelinfo.get(i));
		}
		data.put("orderinfo", hotel);
		return Message.createSuc(data);
	}

	//查看房间状况
	@RequestMapping(value = "/admin/room/status")
	@ResponseBody
	public Message selecHotel(@RequestParam(value = "hotelId", required = false) int id) {
		List<sensorUsing> sensorusing = new ArrayList<sensorUsing>();
		sensorusing = sensorService.selectUsing(id);

		return Message.createSuc(sensorusing.get(sensorusing.size() - 1));
	}

	//新增房间
	@RequestMapping(value = "/admin/room/add")
	@ResponseBody
	public Message addHotel(HttpServletRequest servletRequest,
			/*@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "province", required = false) String province,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "price", required = false) BigDecimal price,
			@RequestParam(value = "longitude", required = false) Double longitude,
			@RequestParam(value = "latitude", required = false) Double latitude,
			@RequestParam(value = "lockStatus", required = false) String lockStatus,
			@RequestParam(value = "sensorStatus", required = false) String sensorStatus,*/
			@RequestParam(value = "room", required = false) MultipartFile room,
			@RequestParam(value = "url", required = false) MultipartFile url) throws Exception {

		/*if (name==null || province==null || city==null || address==null || price==null || lockStatus==null) {
			return Message.createErr("输入有误");
		}*/
		
		hotelInfo hotelinfo = new hotelInfo();
		/*hotelinfo.setName(name);
		hotelinfo.setProvince(province);
		hotelinfo.setCity(city);
		hotelinfo.setAddress(address);
		hotelinfo.setPrice(price);
		hotelinfo.setUseCount(0);
		hotelinfo.setStar(0);
		hotelinfo.setLockStatus(lockStatus);
		hotelinfo.setSensorStatus(sensorStatus);
		hotelinfo.setLongitude(longitude);
		hotelinfo.setLatitude(latitude);
		
		if (rooms.length!=urls.length || rooms.length==0 || urls.length==0) {
			return Message.createErr("文件输入有误");
		}*/
		
		//文件读取操作
		String URL = "";
		/*for (int i=0;i<rooms.length;i++) {
			MultipartFile room = rooms[i];
			MultipartFile url = urls[i];*/
			/*if (room.isEmpty() || url.isEmpty()) {
				return Message.createErr("文件无内容");
			}*/
			//读取room内容
			String rm = Talk.readRm(room);
			System.out.println(rm);
			
			//保存图片至服务器
			String fileName = url.getOriginalFilename();
            File imageFile = new File(servletRequest.getServletContext().getRealPath("/image"), fileName);
            try{
                url.transferTo(imageFile);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
			
			
	        //上传图片获取url
			HttpEntity httpEntity = Talk.upload();
			System.out.println(httpEntity);
			
			//Talk.getFileFromFile(url);
			/*Map<String, File> file = new HashMap<String, File>();
			file.put("smifile", f);
			String ul = Talk.post("https://sm.ms/api/upload", file);*/
	        
	        //URL = URL + rm + ":" + ul + ";";
		//}
		hotelinfo.setImageUrl(URL);
		

		return Message.createSuc(hotelService.insert(hotelinfo));
	}

	//删除房间
	@RequestMapping(value = "/admin/room/delete")
	@ResponseBody
	public Message deleteProvince(@RequestParam(value = "hotelId", required = false) int id) {
		// usingService.delete(id);
		return Message.createSuc(hotelService.delete(id));
	}

	//根据分页获取刷卡记录
	@RequestMapping(value = "/admin/pass")
	@ResponseBody
	public Message getLock(@RequestParam(value = "curr", required = false) int curr) {

		List<lockUsing> lockusing = lockService.getAllUsing();
		List<lockUsing> using = new ArrayList<lockUsing>();
		int len = lockusing.size();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("curr", curr);
		data.put("all", len);

		//十条数据一页
		for (int i = (curr - 1) * 10; i < curr * 10; i++) {
			if (i == len)
				break;
			using.add(lockusing.get(i));
		}
		data.put("info", using);
		return Message.createSuc(data);
	}

	//修改房间信息
	@RequestMapping(value = "/admin/room/chg")
	@ResponseBody
	public Message updateHotel(
			@RequestParam(value = "hotelId", required = false) int hotelId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "province", required = false) String province,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "price", required = false) BigDecimal price,
			@RequestParam(value = "longitude", required = false) Double longitude,
			@RequestParam(value = "latitude", required = false) Double latitude,
			@RequestParam(value = "lockStatus", required = false) String lockStatus,
			@RequestParam(value = "sensorStatus", required = false) String sensorStatus,
			@RequestParam(value = "room", required = false) MultipartFile[] rooms,
			@RequestParam(value = "url", required = false) MultipartFile[] urls) throws IOException {

		if (name==null || province==null || city==null || address==null || price==null || lockStatus==null) {
			return Message.createErr("输入有误");
		}
		
		hotelInfo hotelinfo = hotelService.selectHotel(hotelId);
		hotelinfo.setName(name);
		hotelinfo.setProvince(province);
		hotelinfo.setCity(city);
		hotelinfo.setAddress(address);
		hotelinfo.setPrice(price);
		hotelinfo.setUseCount(0);
		hotelinfo.setStar(0);
		hotelinfo.setLockStatus(lockStatus);
		hotelinfo.setSensorStatus(sensorStatus);
		hotelinfo.setLongitude(longitude);
		hotelinfo.setLatitude(latitude);
		
		if (rooms.length!=urls.length || rooms.length==0 || urls.length==0) {
			return Message.createErr("文件输入有误");
		}
		
		//文件读取操作
		String URL = "";
		for (int i=0;i<rooms.length;i++) {
			MultipartFile room = rooms[i];
			MultipartFile url = urls[i];
			if (room.isEmpty() || url.isEmpty()) {
				return Message.createErr("文件无内容");
			}
			//读取room内容
			String rm = Talk.readRm(room);
	        //上传图片获取url
	        String ul = Talk.result(url);
	        
	        URL = URL + rm + ":" + ul + ";";
		}
		hotelinfo.setImageUrl(URL);

		return Message.createSuc(hotelService.update(hotelinfo));
	}

}
