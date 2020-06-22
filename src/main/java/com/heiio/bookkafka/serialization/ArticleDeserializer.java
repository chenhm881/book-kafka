package com.heiio.bookkafka.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heiio.bookkafka.model.Article;
import org.apache.kafka.common.serialization.Deserializer;
import java.util.Map;

public class ArticleDeserializer implements Deserializer<Article> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Article deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        Article article = null;
        try {
            article = mapper.readValue(bytes, Article.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return article;
    }


    @Override
    public void close() {

    }
}
