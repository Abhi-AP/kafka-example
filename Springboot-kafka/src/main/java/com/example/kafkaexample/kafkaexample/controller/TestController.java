package com.example.kafkaexample.kafkaexample.controller;

import com.example.kafkaexample.kafkaexample.Consumer.MessageConsumer;
import com.example.kafkaexample.kafkaexample.Producer.MessageProducer;
import com.example.kafkaexample.kafkaexample.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @Autowired
    private MessageProducer messageProducer;

    @RequestMapping("/uploadUser")
    public void sendMessage(@RequestParam(value = "name") String name,
                            @RequestParam(value = "age") Integer age) throws JsonProcessingException {
        messageProducer.sendMessage(new User(name, age));
    }
}
