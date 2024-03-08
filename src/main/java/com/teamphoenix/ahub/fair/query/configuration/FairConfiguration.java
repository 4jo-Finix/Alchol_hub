package com.teamphoenix.ahub.fair.query.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.teamphoenix.ahub.fair.query.repository", annotationClass = Mapper.class )
public class FairConfiguration {
}
