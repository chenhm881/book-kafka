package com.heiio.bookkafka;

import com.heiio.bookkafka.config.MyAspect;
import com.heiio.bookkafka.config.MyConfiguration;
import com.heiio.bookkafka.model.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootTest
class BookKafkaApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class);
        SysRole obj = (SysRole) ctx.getBean("role");
        System.out.println(obj);

    }
}
