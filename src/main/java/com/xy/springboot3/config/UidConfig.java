package com.xy.springboot3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @fileName:UidConfig
 * @author:xy
 * @date:2018/12/8
 * @description:
 */
@Configuration
@ImportResource(locations = { "classpath:ext/vesta/vesta-rest-main.xml" })
public class UidConfig {
}
