package com.hotel.luck.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.hotel.luck.bean.sensorUsing;
import com.hotel.luck.service.SensorService;

public class runTaskUtil {
	
	//线程三秒运行一次
	public void runTask(final int hotelid, final String topic, final SensorService sensorService) {
        final long timeInterval = 2000/*3600000*/;// 一小时运行一次
        Runnable runnable = new Runnable() {
            public void run() {
                    // ------- code for task to run
                try {       //你要运行的程序       
                    ClientSearch clientSearch = new ClientSearch();
                    try {
                        clientSearch.start(topic);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                    String flag = "";
                    while (true) {
                    	Thread.sleep(10000); //给十秒时间接收服务器消息
                        String message = clientSearch.resc();
                        if (flag!=null && flag.equals(message)) {
                        	continue;
                        }
                        String[] str = message.split(";");
                        
                        System.out.println(str.length);
                        if (str.length==7) {
                        	sensorUsing sensorusing = new sensorUsing();
                            sensorusing.setHotelId(hotelid);
                            sensorusing.setTvoc(str[0]);
                            sensorusing.setCo2(str[1]);
                            sensorusing.setFire(str[2]);
                            sensorusing.setTemp(str[3]);
                            sensorusing.setHumidity(str[4]);
                            sensorusing.setPoint(str[5]);
                            sensorusing.setShine(str[6]);
                            sensorService.insertmsg(sensorusing);
                            System.out.println("当前传递的消息："+ message);
                            flag = message;
                        }
                        else {
                        	System.out.println("消息格式错误");
                        }
                    }
                    
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // ------- ends here
                try {
                    Thread.sleep(timeInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
