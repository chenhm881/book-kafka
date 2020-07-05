package com.heiio.bookkafka.service;

import com.heiio.bookkafka.model.Article;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ArticleConsumer {

//
//    @KafkaListener(id = "", topics = {"article"}, groupId = "article.first")
//    public void getArticle(ConsumerRecord<String, Article> consumerRecord) {
//        System.out.println("topic:" + consumerRecord.topic() + "; partition: " + consumerRecord.partition() + ";");
//        System.out.println("Author: " + consumerRecord.value().getAuthor() + "; title: " + consumerRecord.value().getTitle());
//    }
//
//    @KafkaListener(id = "", topics = "test", groupId = "test.first")
//    public void getTest(ConsumerRecord<String, String> consumerRecord) {
//        System.out.println("topic:" + consumerRecord.topic() + "; partition: " + consumerRecord.partition() + ";");
//        System.out.println("value: " + consumerRecord.value());
//    }

}
