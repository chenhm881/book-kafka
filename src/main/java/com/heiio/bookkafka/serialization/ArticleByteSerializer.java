package com.heiio.bookkafka.serialization;

import com.heiio.bookkafka.model.Article;
import org.apache.kafka.common.serialization.Serializer;
import org.yaml.snakeyaml.serializer.SerializerException;

import java.nio.ByteBuffer;
import java.util.Map;

public class ArticleByteSerializer implements Serializer<Article> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, Article article) {

        try {
            byte[] bufferTitle;
            int sizeTitle;
            if (article == null) {
                return null;
            }
            if (null != article.getTitle()) {
                bufferTitle = article.getTitle().getBytes("UTF-8");
                sizeTitle = bufferTitle.length;
            } else {
                bufferTitle = new byte[0];
                sizeTitle = 0;
            }
            ByteBuffer byteBuffer = ByteBuffer.allocate(4 + 4 + sizeTitle);
            byteBuffer.putInt(article.getId());
            byteBuffer.putInt(sizeTitle);
            byteBuffer.put(bufferTitle);
            return byteBuffer.array();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SerializerException("Serializer exception");
        }
    }

//    @Override
//    public byte[] serialize(String topic, Headers headers, Article article) {
//        return new byte[0];
//    }


    @Override
    public void close() {

    }
}
