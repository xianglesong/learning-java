package com.xianglesong;

import com.xianglesong.service.RabbitMQSendService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

/**
 * MyStarts
 *
 * @author ma.rulin
 * @date 17/4/26
 */
@EnableAutoConfiguration
@SpringBootApplication
public class MyStarts implements Runnable {

//    @Autowired
//    MyService myService;

    public static void main(String[] args) {
        System.out.println("begin");

        ConfigurableApplicationContext context = SpringApplication.run(MyStarts.class, args);
//        MqSendService myService = (MqSendService) context.getBean("mqSendService");
//        myService.sendMsg("test at " + new Date().toString());

        RabbitMQSendService rabbitMQSendService = (RabbitMQSendService) context.getBean("rabbitMQSendService");
//        rabbitMQSendService.sendMsg("test1 at " + new Date().toString());


        rabbitMQSendService.sendMsg("test2 at " + new Date().toString());

    }

    @Override
    public void run() {
        System.out.print("begin run");
    }
}
