package com.heiio.bookkafka.controller;

import com.heiio.bookkafka.model.Article;
import com.heiio.bookkafka.model.blog.Blog;
import com.heiio.bookkafka.service.ArticleProducer;
import com.heiio.bookkafka.service.BlogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private ArticleProducer articleProducer;

    @Autowired
    private BlogProducer blogProducer;

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

    @RequestMapping("/bloglist")
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = new ArrayList<>();
        Blog blog = new Blog();
        blog.setId(1L);
        blog.setTitle("blog1");
        blogList.add(blog);
        ResponseEntity<List<Blog>> responseEntity = new ResponseEntity<>(blogList, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping("/createBlog")
    public String createBlog (@RequestBody Blog blog) {
        blogProducer.send(blog);
        //articleProducer.send(test);
        return "successfully";
    }


}
