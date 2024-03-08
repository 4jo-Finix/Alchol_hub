package com.teamphoenix.ahub.post.query.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.teamphoenix.ahub.post.query", annotationClass = Mapper.class)
public class PostConfiguration {
}