package com.properties.examples.examples.strategy_example;


import org.springframework.stereotype.Service;

@Service("push")
public class PushSender implements MessageSender {
    @Override
    public String doSomeCase() {
       return  "send push message";
    }
}
