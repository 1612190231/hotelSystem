package com.hotel.luck.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class DBUtil {
    // �������ݿ����Ӳ���
    public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://111.231.111.11:3306/hotelsql";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";

    // ע�����ݿ�����
    static {
        try {
            Class.forName(DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            System.out.println("ע��ʧ�ܣ�");
            e.printStackTrace();
        }
    }

    // ��ȡ����
    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // �ر�����
    public static void closeConn(Connection conn) {
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("�ر�����ʧ�ܣ�");
                e.printStackTrace();
            }
        }
    }
    //����
    public static void main(String[] args) throws SQLException {
        System.out.println(DBUtil.getConn());
    }

}