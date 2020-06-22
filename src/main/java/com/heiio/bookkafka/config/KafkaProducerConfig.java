package com.heiio.bookkafka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;


//@Configuration
//public class KafkaProducerConfig {
//
//    @Bean
//    public KafkaTemplate kafkaTemplate() {
//        HashMap<String, Object> configs = new HashMap<>();
//        DefaultKafkaProducerFactory producerFactory = new DefaultKafkaProducerFactory(configs);
//        return new KafkaTemplate(producerFactory);
//    }
//}
