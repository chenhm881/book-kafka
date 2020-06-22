package com.heiio.bookkafka.serialization;

import com.heiio.bookkafka.model.Article;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.DeserializationException;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Map;

public class ArticleByteDeserializer implements Deserializer<Article> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Article deserialize(String s, byte[] bytes) {

        try {
            int sizeTitle;
            int articleId;
            String articleTitle;

            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
            articleId = byteBuffer.getInt();
            sizeTitle = byteBuffer.getInt();
            byte[] byteTitle = new byte[sizeTitle];
            byteBuffer.get(byteTitle);
            articleTitle = new String(byteTitle, "UTF-8");

            Article article = new Article();
            article.setId(articleId);
            article.setTitle(articleTitle);

            return article;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new DeserializationException("Deserializer exception", bytes, true, null);
        }
    }


    @Override
    public void close() {

    }
}
