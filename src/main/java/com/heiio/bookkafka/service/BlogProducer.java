package com.heiio.bookkafka.service;

import com.heiio.bookkafka.model.blog.Blog;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(Blog blog) {
        kafkaTemplate.getDefaultTopic();
        this.send("topic.blog", 1, "", blog);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void send(String topic, Integer partition, String key, Blog blog) {
        ProducerRecord<String, Blog> producerRecord = new ProducerRecord<>(topic, blog);
        kafkaTemplate.executeInTransaction(tx -> {
            tx.send(producerRecord);
            return true;
        });
    }
}
