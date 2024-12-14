package com.ssafy.study_04_bohyung.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.study_04_Bohyung.model.dao")
public class DBConfig {

}
