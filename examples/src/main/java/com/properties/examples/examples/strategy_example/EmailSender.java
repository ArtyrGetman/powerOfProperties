package com.properties.examples.examples.strategy_example;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailSender implements MessageSender {
    @Override
    public String doSomeCase() {
       return "send email";
    }
}
