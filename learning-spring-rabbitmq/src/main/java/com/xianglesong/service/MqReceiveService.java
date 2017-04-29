package com.xianglesong.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * MqReceiveService
 *
 * @author ma.rulin
 * @date 17/4/27
 */
@Component
public class MqReceiveService {

  @RabbitListener(queues = "queue-1")
  public void processMessageM(Message messgage) {
    String object = new String(messgage.getBody());
    System.out.println("received: " + object);
  }

//  @RabbitListener(queues = "queue-1")
//  public void processMessage1(Message messgage) {
//    String object = new String(messgage.getBody());
//    System.out.println("received1: " + object);
//    throw new RuntimeException("test");
//  }


  // @RabbitListener(queues = "queue-1")
  // public void processMessage1(String content) {
  // System.out.println("received 2: " + content);
  // }
  //
  // @RabbitListener(queues = "queue-2")
  // public void processMessage2(String content) {
  // System.out.println("received -2: " + content);
  // }

  // @RabbitListener(queues = "queue-3")
  // public void processMessage3(String content) {
  // System.out.println("received -3: " + content);
  // }

//  @RabbitListener(queues = "queue-1f")
//  public void processMessagef(String content) {
//    System.out.println("received 1f: " + content);
//  }
//
//  @RabbitListener(queues = "queue-2f")
//  public void processMessage2f(String content) {
//    System.out.println("received 2f: " + content);
//  }

}
