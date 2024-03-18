package com.teamphoenix.ahub.fair.command.security;

import com.teamphoenix.ahub.fair.command.service.FairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final FairService fairService;
    private final Environment environment;

    @Autowired
    public WebSecurityConfig(FairService fairService,
                             Environment environment) {
        this.fairService = fairService;
        this.environment = environment;
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable());

        http.authorizeHttpRequests((auth) -> auth
                        .requestMatchers(new AntPathRequestMatcher("/fairs/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/news/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/actuator/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
                );

        return http.build();
    }

}
