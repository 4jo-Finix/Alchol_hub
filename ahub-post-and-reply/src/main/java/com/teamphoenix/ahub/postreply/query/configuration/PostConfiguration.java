package com.teamphoenix.ahub.postreply.query.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.teamphoenix.ahub.postreply.query", annotationClass = Mapper.class)
public class PostConfiguration {
}