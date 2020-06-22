package com.heiio.bookkafka.serialization;

import com.heiio.bookkafka.model.Article;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class ArticleObjectDeserializer implements Deserializer<Article> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Article deserialize(String s, byte[] bytes) {
        Object readObject = null;
        try (ByteArrayInputStream in = new ByteArrayInputStream(bytes);
             ObjectInputStream inputStream = new ObjectInputStream(in)){
            readObject = inputStream.readObject();
        } catch (Exception e)
        { e.printStackTrace(); }
        return (Article)readObject;
    }

    @Override
    public void close() {

    }
}
