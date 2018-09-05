package com.spmjava.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author 齐伟超
 * @date 2018-09-04 17:43
 * @since 1.0.0
 **/
public class JdbcUtils {
    private static String username;
    private static String password;
    private static String driver;
    private static String url;

    private JdbcUtils() {
    }

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
