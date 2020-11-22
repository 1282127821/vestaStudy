package com.xy.切换数据库;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @fileName:MysqlDemo
 * @author:xy
 * @date:2020/9/7
 * @description:
 */
@Service
@ConfigurationProperties(prefix = "spring.datasource")
public class MysqlDemo {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void xx(){
    }


}
