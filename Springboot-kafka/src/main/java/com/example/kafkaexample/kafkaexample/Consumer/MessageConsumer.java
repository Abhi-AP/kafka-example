package com.example.kafkaexample.kafkaexample.Consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MessageConsumer {

    @Value(value="${kafka.message.topic}")
    private String messageTopic;

    @KafkaListener(topics="${kafka.message.topic}", groupId = "DEFAULT_GROUP")
    public void receiveMessage(String payload){
        System.out.println("PAYLOAD RECEIVED " + payload);
    }

}
