package com.heiio.bookkafka.serialization;

import com.heiio.bookkafka.model.Article;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class ArticleObjectSerializer implements Serializer<Article> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

   @Override
   public byte[] serialize(String s, Article article) {
        byte[] bb = null;
        try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()){
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArray);
            outputStream.writeObject(article);
            outputStream.flush();
            bb = byteArray.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bb;
   }


    @Override
    public void close() {

    }
}
