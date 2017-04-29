package com.xianglesong.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RabbitMQSendService
 *
 * @author ma.rulin
 * @date 17/4/27
 */
@Service
public class RabbitMQSendService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg) {

        System.out.println("confirm lister = " + rabbitTemplate.isConfirmListener());
//        System.out.println("confirm lister" + rabbitTemplate.setConfirmCallback(););
        rabbitTemplate.setMandatory(true);
        if (!rabbitTemplate.isConfirmListener()) {
            rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
                public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                    System.out.println("ack: " + ack + ". correlationData: " + correlationData + " cause : " + cause);
                }
            });
        }

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("text: " + replyText + " code: " + replyCode + " exchange: " + exchange + " routingKey :" + routingKey);
            }
        });

         rabbitTemplate.convertAndSend("exchange-1", "route-11", msg, new CorrelationData("xxx"));

         // rabbitTemplate.convertAndSend("exchange-1", "route-1", msg);



        System.out.println("send msg: " + msg);

    }
}
