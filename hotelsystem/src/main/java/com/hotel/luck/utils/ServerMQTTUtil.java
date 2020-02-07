package com.hotel.luck.utils;

import org.eclipse.paho.client.mqttv3.MqttClient;  
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;  
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;  
import org.eclipse.paho.client.mqttv3.MqttException;  
import org.eclipse.paho.client.mqttv3.MqttMessage;  
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;  
import org.eclipse.paho.client.mqttv3.MqttTopic;  
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;  
/** 
 * Title:Server ���Ƿ�����Ϣ�ķ����
 * Description: �����������ͻ����������⣬����ͬ�ͻ��˿��������������ͬ���� 
 * @author rao
 */  
public class ServerMQTTUtil {  

    //tcp://MQTT��װ�ķ�������ַ:MQTT����Ķ˿ں�  
    public static final String HOST = "tcp://111.231.111.11:1883";  
    //����MQTT��ID��������MQTT����������ָ��  
    private static final String clientid = "server11";  

    private MqttClient client;
    private MqttTopic mqttTopic;

    /** 
     * ���캯�� 
     * @throws MqttException 
     */  
    public ServerMQTTUtil(String topic) throws MqttException {  
        // MemoryPersistence����clientid�ı�����ʽ��Ĭ��Ϊ���ڴ汣��  
        client = new MqttClient(HOST, clientid, new MemoryPersistence());  
        connect(topic);
    }  

    /** 
     *  �������ӷ����� 
     */  
    private void connect(String topic) {  
        MqttConnectOptions options = new MqttConnectOptions();                                      
        options.setCleanSession(false);
        // ���ó�ʱʱ��  
        options.setConnectionTimeout(10);  
        // ���ûỰ����ʱ��  
        options.setKeepAliveInterval(20);  
        try {  
//          client.setCallback(new PushCallback());  
            client.connect(options);  
            mqttTopic = client.getTopic(topic);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  

    //������Ϣ����ȡ��ִ 
    public void publish(MqttMessage message) throws MqttPersistenceException,  
            MqttException, InterruptedException {
    	MqttDeliveryToken token = mqttTopic.publish(message);  
        
        token.waitForCompletion();  
        System.out.println("message is published completely! "  
                + token.isComplete());  
        System.out.println("messageId:" + token.getMessageId());
        token.getResponse();
        if (client.isConnected())  
            client.disconnect(10000);  
        System.out.println("Disconnected: delivery token \"" + token.hashCode()  
            + "\" received: " + token.isComplete()); 
    }

    public MqttTopic getMqttTopic() {
        return mqttTopic;
    }

    public void setMqttTopic(MqttTopic mqttTopic) {
        this.mqttTopic = mqttTopic;
    }

}  