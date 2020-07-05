package com.heiio.bookkafka.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiio.bookkafka.model.Article;
import com.heiio.bookkafka.model.blog.Blog;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class BlogDeserializer implements Deserializer<Blog> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Blog deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        Blog blog = null;
        try {
            blog = mapper.readValue(bytes, Blog.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blog;
    }


    @Override
    public void close() {

    }
}
