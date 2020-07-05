package com.heiio.bookkafka.service;

import com.heiio.bookkafka.mapper.BlogMapper;
import com.heiio.bookkafka.model.blog.Blog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BlogConsumer {

    @Autowired
    private BlogMapper blogMapper;

    @KafkaListener(id = "blogfirst", groupId = "blog.first",
            topicPartitions = {
            @TopicPartition(topic = "topic.blog", partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0"))
    })
    public void fetchBlog(ConsumerRecord<String, Blog> consumerRecord) {
        Blog blog = consumerRecord.value();
        String topic = consumerRecord.topic();
        int partition = consumerRecord.partition();
        long offset = consumerRecord.offset();
        Map<String, Integer> returnMap = new HashMap<String, Integer>();
        blogMapper.insertBlog(blog, topic, partition, offset, returnMap);
    }
}
