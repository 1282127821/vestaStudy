package com.xy.spring看书.test;

import ch.qos.logback.core.db.dialect.DBUtil;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @fileName:SimpleTestConfig
 * @author:xy
 * @date:2019/6/9
 * @description:
 */
@Configuration
@ComponentScan(basePackages = {"com.xy.spring看书.test"},
excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE)})
@Profile("test")
public class SimpleTestConfig {
    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder databaseBuilder=new EmbeddedDatabaseBuilder();
        return databaseBuilder.setType(EmbeddedDatabaseType.DERBY).build();
    }
}
