package com.heiio.bookkafka.config;

import com.heiio.bookkafka.model.SysRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass = false)
@Configuration
@ComponentScan("com.heiio.bookkafka")

public class MyConfiguration {

    @Bean
    public SysRole getSysRole() {
        SysRole sysRole = new SysRole();
        sysRole.setId(1);
        return sysRole;
    }


}
