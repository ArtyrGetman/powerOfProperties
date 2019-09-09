package com.properties.examples.examples;

import com.properties.examples.examples.strategy_example.MessageSender;
import com.properties.examples.examples.strategy_example.properties_strategy_case.SenderProcessorByPropInitializer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
@RequiredArgsConstructor
public class ExamplesApplication implements CommandLineRunner {

    private final SenderProcessorByPropInitializer senderProcessorByPropInitializer;
    private final Map<String, MessageSender> messageSenderMapMap;

    public static void main(String[] args) {
        SpringApplication.run(ExamplesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("\n Case 1. Base");
        messageSenderMapMap.forEach((s, messageSender)
                -> System.out.println(s + "/" + messageSender.doSomeCase()));
        System.out.println("\n Case 2. Get senders from application.properties");
        senderProcessorByPropInitializer.getSenderMap().forEach((s, messageSender)
                -> System.out.println(s + "/" + messageSender.doSomeCase()));
    }
}
