package com.hotel.luck.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.luck.bean.userInfo;
import com.hotel.luck.service.UserInfoService;
import com.hotel.luck.utils.DBUtil;
import com.hotel.luck.utils.ImageUtil;
import com.hotel.luck.utils.Message;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class UserInfoController {
	@Autowired
	UserInfoService userinfoService ;

	//用户提交审核
	@RequestMapping(value="/submitID")
	@ResponseBody
	public Message submitIDcard(
			@RequestParam(value="userId",required=false)int id,
			@RequestParam(value="IDCard",required=false)String IDCard,
			@RequestParam(value="cardURL",required=false)String cardURL,
			@RequestParam(value="bathday",required=false)Date bathday
		) {
		
		String path = cardURL;
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream in = null;
        try {
            in = ImageUtil.readImage(path);
            conn = DBUtil.getConn();
            String sql = "insert into IDphoto (userid,photo)values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setBinaryStream(2, in, in.available());
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("插入成功！");
            } else {
                System.out.println("插入失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (null != ps) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
        userInfo userinfo=new userInfo();
		userinfo.setUserId(id);
		userinfo.setUserName(IDCard);
		userinfo.setBathday(bathday);
		return Message.createSuc(userinfoService.update(userinfo));
	}
	
	//更改密码
	@RequestMapping(value="/updatepassword")
	@ResponseBody
	public Message updatePassword(
								@RequestParam(value="userId",required=false)int id,
								@RequestParam(value="password",required=false)String password
			                 ) {
		
		userInfo userinfo=new userInfo();
		userinfo.setUserId(id);
		userinfo.setPassword(password);
		return Message.createSuc(userinfoService.update(userinfo));
	}
	
	//更改手机号
	@RequestMapping(value="/updatetelephone")
	@ResponseBody
	public Message updateTelephone(
			@RequestParam(value="userId",required=false)int id,
			@RequestParam(value="telephone",required=false)String telephone
		) {
		
		userInfo userinfo=new userInfo();
		userinfo.setUserId(id);
		userinfo.setTelephone(telephone);
		return Message.createSuc(userinfoService.update(userinfo));
	}

	//身份审核
	@RequestMapping(value="/judgeID")
	@ResponseBody
	public Message judgeID(
			@RequestParam(value="userId",required=false)int userid
			) {
		
        File file = new File("D:\\image_ID");
        if(!file.exists())    {    
            try {    
                file.createNewFile();    
            } catch (IOException e) {    
                // TODO Auto-generated catch block    
                e.printStackTrace();    
            }    
        }    
        
        String targetPath = "D:/image_ID/"+userid+".png";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select * from IDphoto where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            rs = ps.executeQuery();
            while (rs.next()) {
                InputStream in = rs.getBinaryStream("photo");
                ImageUtil.readBin2Image(in, targetPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        userInfo userinfo = new userInfo();
        userinfo = userinfoService.select(userid);
        userinfo.setCardUrl(targetPath);
        return Message.createSuc(userinfo);
    }

}