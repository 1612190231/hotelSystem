package com.hotel.luck.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.hotel.luck.bean.sensorUsing;
import com.hotel.luck.service.SensorService;

public class runTaskUtil {
	
	//�߳���������һ��
	public void runTask(final int hotelid, final String topic, final SensorService sensorService) {
        final long timeInterval = 2000/*3600000*/;// һСʱ����һ��
        Runnable runnable = new Runnable() {
            public void run() {
                    // ------- code for task to run
                try {       //��Ҫ���еĳ���       
                    ClientSearch clientSearch = new ClientSearch();
                    try {
                        clientSearch.start(topic);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                    String flag = "";
                    while (true) {
                    	Thread.sleep(10000); //��ʮ��ʱ����շ�������Ϣ
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
                            System.out.println("��ǰ���ݵ���Ϣ��"+ message);
                            flag = message;
                        }
                        else {
                        	System.out.println("��Ϣ��ʽ����");
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
