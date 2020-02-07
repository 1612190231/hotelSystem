package com.hotel.luck.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.privilege;
import com.hotel.luck.service.PrivilegeService;
import com.hotel.luck.utils.Message;

@Controller
public class PrivilegeController {
	@Autowired
	PrivilegeService privilegeService ;

	//�鿴���з���Ȩ��
	@RequestMapping(value="/selectallprivilege")
	@ResponseBody
	public Message selectAll() {
		return Message.createSuc(privilegeService.getAll());
	}

	//�鿴ָ������Ȩ��
	@RequestMapping(value="/selecthotelprivilege")
	@ResponseBody
	public Message selecHotel(@RequestParam(value="hotelId",required=false)int id) {

		return Message.createSuc(privilegeService.selectHotel(id));
	}

	//�鿴ָ���û�Ȩ��
	@RequestMapping(value="/selectuserprivilege")
	@ResponseBody
	public Message selecUser(@RequestParam(value="orderId",required=false)int id) {

		return Message.createSuc(privilegeService.selectUser(id));
	}
	//ɾ��Ȩ��
	@RequestMapping(value="/deleteprivilege")
	@ResponseBody
	public Message deleteProvince(@RequestParam(value="orderId",required=false)int id) {
		return Message.createSuc(privilegeService.delete(id));
	}
}





