package com.hotel.luck.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 模拟post协议上传文件 源辰信息
 * 
 * @author navy 2017年7月27日
 */
public class MyPost {
	public static void main(String[] args) {
//      System.out.println("file = " + file);
      CloseableHttpClient httpClient = HttpClients.createDefault();
      HttpPost httpPost = new HttpPost("https://sm.ms/api/upload");//建立HttpPost对象,改成自己的地址
      URL resource = MyPost.class.getClassLoader().getResource("screenshot.png");
      String path = resource.getPath();
      System.out.println("path = " + path);
      File file = new File(path);//相对路径使用不了的话,使用图片绝对路径
      if(!file.exists()){//判断文件是否存在
          System.out.print("文件不存在");
          return;
      }
      FileBody bin = new FileBody(file, ContentType.create("image/png", Consts.UTF_8));//创建图片提交主体信息
      HttpEntity entity = MultipartEntityBuilder
              .create()
              .setCharset(Charset.forName("utf-8"))
              .setContentType(ContentType.MULTIPART_FORM_DATA)
              .addPart("smfile", bin)//添加到请求
              .build();
      httpPost.setEntity(entity);
      httpPost.addHeader("user-agent","Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
      httpPost.addHeader("connection", "Keep-Alive");
      HttpResponse response= null;//发送Post,并返回一个HttpResponse对象
      try {
          response = httpClient.execute(httpPost);
          if(response.getStatusLine().getStatusCode()==200) {//如果状态码为200,就是正常返回
              String result = EntityUtils.toString(response.getEntity());
              System.out.print(result);
          }
          System.out.println("response = " + response);
      } catch (IOException e) {
          e.printStackTrace();
      }
      System.out.print(response);
      System.out.print("结束");
  }
}
