package com.properties.examples.examples.strategy_example;

import org.springframework.stereotype.Service;

@Service("sms")
public class SmsSender implements MessageSender {
    @Override
    public String doSomeCase() {
       return "send sms";
    }
}
