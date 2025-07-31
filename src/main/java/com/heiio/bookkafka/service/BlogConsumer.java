package com.heiio.bookkafka.service;

import com.heiio.bookkafka.mapper.BlogMapper;
import com.heiio.bookkafka.model.blog.Blog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogConsumer {

    @Autowired
    private BlogMapper blogMapper;

    Logger logger = LoggerFactory.getLogger(BlogConsumer.class);

    @KafkaListener(id = "blogfirst", groupId = "blog.first",
            containerFactory = "batchContainerFactory",
            topicPartitions = {
            @TopicPartition(topic = "topic.blog", partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0"))
    })
    public void fetchBlog(List<ConsumerRecord<String, Blog>> consumerRecord, Acknowledgment acknowledgment) {
        Blog blog = consumerRecord.get(0).value();
        String topic = consumerRecord.get(0).topic();
        int partition = consumerRecord.get(0).partition();
        long offset = consumerRecord.get(0).offset();
        acknowledgment.acknowledge();
        logger.info("已提交偏移量: {}", consumerRecord.get(0).offset());
        //Map<String, Integer> returnMap = new HashMap<String, Integer>();
        //blogMapper.insertBlog(blog, topic, partition, offset, returnMap);
    }
}
