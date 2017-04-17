package com.xianglesong.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * KafkaBootStartup
 *
 * @author ma.rulin
 * @date 17/4/17
 */
@SpringBootApplication
public class KafkaBootStartup {


    public static void main(String[] args) {
        System.out.println("begin ");
        ConfigurableApplicationContext context = SpringApplication.run(KafkaBootStartup.class, args);

        System.out.println("end ");
    }
}
