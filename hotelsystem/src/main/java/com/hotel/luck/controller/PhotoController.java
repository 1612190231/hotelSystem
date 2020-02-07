package com.hotel.luck.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.R1;
import com.hotel.luck.bean.R2;
import com.hotel.luck.service.PhotoService;
import com.hotel.luck.utils.Message;

@Controller
public class PhotoController {
	
	@Autowired
	PhotoService photoService;
	
	//返回第一组照片
	@RequestMapping(value = "/r1/get")
	@ResponseBody
	public Message selectR1() {
		List<R1> r1 = photoService.getAll();
		String[] photos = new String[12];
		for (int i=0;i<r1.size();i++) {
			photos[i] = r1.get(i).getUrl();
		}
		return Message.createSuc(photos);
	}
	
	//返回第二组照片
	@RequestMapping(value = "/r2/get")
	@ResponseBody
	public Message selectF2() {
		List<R2> r2 = photoService.getR2All();
		String[] photos = new String[12];
		for (int i=0;i<r2.size();i++) {
			photos[i] = r2.get(i).getUrl();
		}
		return Message.createSuc(photos);
	}
}
