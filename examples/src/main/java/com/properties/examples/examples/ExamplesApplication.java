package com.properties.examples.examples;

import com.properties.examples.examples.method_with_default_propertie_value.DoCheck;
import com.properties.examples.examples.strategy_example.MessageSender;
import com.properties.examples.examples.strategy_example.properties_strategy_case.SenderProcessorByPropInitializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
@RequiredArgsConstructor
@Log4j2
public class ExamplesApplication implements CommandLineRunner {

    private final SenderProcessorByPropInitializer senderProcessorByPropInitializer;
    private final Map<String, MessageSender> messageSenderMapMap;
    private final DoCheck doCheck;

    public static void main(String[] args) {
        SpringApplication.run(ExamplesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("\n Case 1. Base");
        System.out.println(messageSenderMapMap.get("sms").doSomeCase());
        System.out.println("\n Case 1. Get sender bean from properties");
        System.out.println(senderProcessorByPropInitializer.getSenderMap().get("push").doSomeCase());

        doCheck.doSomeCheck();
    }
}
