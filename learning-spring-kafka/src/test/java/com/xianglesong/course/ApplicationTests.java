package com.xianglesong.course;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianglesong.course.KafkaBootStartup;

import java.util.Date;


/**
 * ApplicationTests
 *
 * @author ma.rulin
 * @date 17/4/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(KafkaBootStartup.class)
public class ApplicationTests {

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Before
    public void setUp() {
    }

    @Test
    public void testKafkaSend() throws Exception {
        System.out.println("test kafka send.");
        kafkaTemplate.send("test-topic2", "hello test : " + new Date()) ;
        System.out.println("test kafka send end.");
    }

    @Test
    public void testKafkaRecv() throws Exception {
        System.out.println("test kafka recv.");
        System.out.println("test kafka recv end.");
    }

    @Test
    public void testKafka() {
        System.out.println("test kafka end.");
    }
}