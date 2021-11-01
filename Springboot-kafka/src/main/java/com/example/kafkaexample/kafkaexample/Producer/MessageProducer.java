package com.example.kafkaexample.kafkaexample.Producer;

import com.example.kafkaexample.kafkaexample.config.KafkaConfig;
import com.example.kafkaexample.kafkaexample.config.ProducerConfig;
import com.example.kafkaexample.kafkaexample.util.ObjectUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@PropertySource(value="application.properties")
@Service
public class MessageProducer {

    @Value(value="${kafka.message.topic}")
    private String messageTopic;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private ObjectUtils objectUtils;

    public void sendMessage(Object message) throws JsonProcessingException {
        String messageAsStr = objectUtils.serializeObject(message);

        ListenableFuture<SendResult<String, Object>> sendResultListenableFuture = kafkaTemplate.send(messageTopic, messageAsStr);
        sendResultListenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Message sending failed because of " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println("Sent message " + message + " with offset " + result.getRecordMetadata().offset());
            }
        });
    }
}
