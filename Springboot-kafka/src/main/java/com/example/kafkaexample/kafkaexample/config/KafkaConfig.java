package com.example.kafkaexample.kafkaexample.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value="application.properties")

public class KafkaConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootStrapAddress;

    @Value(value = "${kafka.message.topic}")
    private String messageTopic;

    @Bean
    public KafkaAdmin getKafkaAdmin(){
        Map<String, Object> configs = new HashMap<String, Object>(){{
                put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapAddress);
        }};
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic getNewTopic(){
        return TopicBuilder.name(messageTopic)
                           .partitions(2)
                           .replicas(1)
                           .build();
    }


}
