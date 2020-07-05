package com.heiio.bookkafka.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiio.bookkafka.model.Article;
import com.heiio.bookkafka.model.blog.Blog;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class BlogSerializer implements Serializer<Blog> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, Blog blog) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(blog).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    @Override
    public void close() {

    }
}
