package com.example.Kafka2.Kafka2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilConfig{

    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
}

