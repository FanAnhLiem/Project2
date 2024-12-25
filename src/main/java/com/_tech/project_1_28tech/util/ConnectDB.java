package com._tech.project_1_28tech.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;

@PropertySource("classpath:application-uat.properties")
public class ConnectDB {
    @Value("${spring.datasource.url}") private String Url;

    @Value("${spring.datasource.username}") private String Username;

    @Value("${spring.datasource.password}") private String Password;

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Url, Username, Password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
