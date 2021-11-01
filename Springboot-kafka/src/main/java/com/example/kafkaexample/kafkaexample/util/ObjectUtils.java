package com.example.kafkaexample.kafkaexample.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class ObjectUtils {

    @Autowired
    private MappingJackson2HttpMessageConverter springMvcJacksonConverter;

    public  String serializeObject(Object object) throws JsonProcessingException {
        return springMvcJacksonConverter.getObjectMapper().writeValueAsString(object);
    }
}
