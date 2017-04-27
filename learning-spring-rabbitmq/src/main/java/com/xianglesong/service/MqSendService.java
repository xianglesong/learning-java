package com.xianglesong.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MyService
 *
 * @author ma.rulin
 * @date 17/4/26
 */
@Service
public class MqSendService {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendMsg(String msg) {
        System.out.println("send");
        // amqpTemplate.convertAndSend("exchange-1", "route-1", msg);

        amqpTemplate.convertAndSend("xtopic", "", msg);
        System.out.println("send end");
    }
}
