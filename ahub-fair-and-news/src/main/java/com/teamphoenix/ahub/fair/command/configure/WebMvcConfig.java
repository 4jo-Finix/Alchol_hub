package com.teamphoenix.ahub.fair.command.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final BearerTokenInterceptor bearerTokenInterceptor;

    @Autowired
    public WebMvcConfig(BearerTokenInterceptor bearerTokenInterceptor) {
        this.bearerTokenInterceptor = bearerTokenInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bearerTokenInterceptor)
                .addPathPatterns("/fairs/new")
                .addPathPatterns("/fairs/{postNum}")
                .addPathPatterns("/news/new");
    }
}
