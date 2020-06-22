package com.heiio.bookkafka.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiio.bookkafka.model.Article;
import org.apache.kafka.common.serialization.Serializer;
import java.util.Map;

public class ArticleSerializer implements Serializer<Article> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, Article article) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(article).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    @Override
    public void close() {

    }
}
