package com.work.finance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * @author developer
 */
@SpringBootApplication
@ComponentScan("com.work.finance")
@MapperScan("com.work.finance.mapper")
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("done");
    }

}
