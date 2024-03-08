package com.teamphoenix.ahub.news.query.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.teamphoenix.ahub.news.query", annotationClass = Mapper.class)
public class NewsConfiguration {
}
