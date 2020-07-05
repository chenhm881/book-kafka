package com.heiio.bookkafka.service;

import com.heiio.bookkafka.model.Article;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.network.KafkaChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Properties;

@Service
public class ArticleProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private Properties properties = new Properties();

    private static final String topic = "article";

    private static final int partition = 1;

    private static final String key = "";

    public void send(Article article) {
        this.send(topic, partition, key, article);
    }

    public void send(String test) {
        this.send(topic, partition, key, test);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void send(String topic, Integer partition, String key, Article article) {

        ProducerRecord<String, Article>  producerRecord = new ProducerRecord<>(topic, article);
        kafkaTemplate.executeInTransaction( tx -> {
            tx.send(producerRecord);
            return true;
        });


    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void send(String topic, Integer partition, String key, String value) {

        ProducerRecord<String, String>  producerRecord = new ProducerRecord<>("test", value);
        kafkaTemplate.executeInTransaction( tx -> {
            tx.send(producerRecord);
            return true;
        });

    }


}
