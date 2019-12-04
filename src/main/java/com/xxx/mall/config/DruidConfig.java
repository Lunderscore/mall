package com.xxx.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource("classpath:/mybatis/druid/druid.xml")
public class DruidConfig {
}
