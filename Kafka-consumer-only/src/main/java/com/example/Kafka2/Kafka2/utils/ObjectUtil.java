package com.example.Kafka2.Kafka2.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class ObjectUtil {

    @Autowired
    private MappingJackson2HttpMessageConverter springMvcJacksonConverter;


    public  Object deserializeObject(String json, Class classType) throws JsonProcessingException {
        return springMvcJacksonConverter.getObjectMapper().readValue(json, classType);
    }
}
