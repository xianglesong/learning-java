package com.xianglesong.rpc;

import java.util.Calendar;
import java.util.Date;

public class SayHelloServiceImpl implements SayHelloService{
  
  @Override
  public String sayHello(String arg) {
      return "Hello " + arg + " " + System.currentTimeMillis() ;
  }

}