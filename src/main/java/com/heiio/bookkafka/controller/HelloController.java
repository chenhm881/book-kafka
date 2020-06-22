package com.heiio.bookkafka.controller;

import com.heiio.bookkafka.model.Article;
import com.heiio.bookkafka.service.ArticleProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private ArticleProducer articleProducer;

    @RequestMapping("/producer")
    public String articleProducer (Article article) {
         articleProducer.send(article);
         return "";
    }

    @RequestMapping("/test")
    public String testProducer (String test) {
        articleProducer.send(test);
        return "";
    }

}
