package com.example.boot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-06-06 22:23
 */
@Configuration
public class StudentAutoConfiguration {
    @Bean
    public Student student() {
        return new Student();
    }
}
