package com.hotel.luck.utils;

import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * ģ��һ���ͻ��˽�����Ϣ
 * 
 * @author rao
 *
 */
public class ClientSearch {
	public static String str = "";
	public static final String HOST = "tcp://111.231.111.11:1883";
	private static final String clientid = "client13";
	private MqttClient client;
	private MqttConnectOptions options;
	@SuppressWarnings("unused")
	private ScheduledExecutorService scheduler;

	public void start(String TOPIC1) throws MqttException {
		// hostΪ��������clientid������MQTT�Ŀͻ���ID��һ����Ψһ��ʶ����ʾ��MemoryPersistence����clientid�ı�����ʽ��Ĭ��Ϊ���ڴ汣��
		client = new MqttClient(HOST, clientid, new MemoryPersistence());
		// MQTT����������
		options = new MqttConnectOptions();
		// �����Ƿ����session,�����������Ϊfalse��ʾ�������ᱣ���ͻ��˵����Ӽ�¼������Ϊtrue��ʾÿ�����ӵ������������µ��������
		options.setCleanSession(false);
		// ���ó�ʱʱ�� ��λΪ��
		options.setConnectionTimeout(10);
		// ���ûỰ����ʱ�� ��λΪ�� ��������ÿ��1.5*20���ʱ����ͻ��˷��͸���Ϣ�жϿͻ����Ƿ����ߣ������������û�������Ļ���
		options.setKeepAliveInterval(20);
		// ���ûص�
		client.setCallback(new MqttCallback() {
			public void connectionLost(Throwable cause) {
				// ���Ӷ�ʧ��һ����������������� //
				System.out.println("���ӶϿ�������������");
			}

			public void deliveryComplete(IMqttDeliveryToken token) {
				System.out.println("deliveryComplete---------" + token.isComplete());
			}

			public void messageArrived(String topic, MqttMessage message) throws Exception {
				try {
					str = message.toString();
					System.out.println(" �ӷ������յ�����ϢΪ:"+message.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// MqttTopic topic = client.getTopic(TOPIC1);
		// setWill�����������Ŀ����Ҫ֪���ͻ����Ƿ���߿��Ե��ø÷������������ն˿ڵ�֪ͨ��Ϣ
		// options.setWill(topic, "close".getBytes(), 2, true);
		// ����
		client.connect(options);
		// ������Ϣ
		int Qos = 1;
		String topic1 = TOPIC1;
		client.subscribe(topic1, Qos);
	}

	@SuppressWarnings("static-access")
	// ���������ô�������Ϣ����
	public String resc() {
		return this.str;
	}
}
