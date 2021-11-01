package com.example.Kafka2.Kafka2.consumer;

import com.example.Kafka2.Kafka2.model.User;
import com.example.Kafka2.Kafka2.utils.ObjectUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @Autowired
    private ObjectUtil objectUtil;

    @KafkaListener(topics = "${kafka.message.topic}", groupId = "DEFAULT_GROUP")
    public void receiveMessage(String payload) throws JsonProcessingException {
        User user = (User) objectUtil.deserializeObject(payload, User.class);
        System.out.println("[" + user.getName() + "]" + "[" + user.getAge() + "]");
    }


}
