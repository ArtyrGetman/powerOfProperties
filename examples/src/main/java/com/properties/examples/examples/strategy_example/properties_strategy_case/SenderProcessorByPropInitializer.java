package com.properties.examples.examples.strategy_example.properties_strategy_case;

import com.properties.examples.examples.strategy_example.MessageSender;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Component
@ConfigurationProperties(value = "sender")
public class SenderProcessorByPropInitializer {
    private final ApplicationContext applicationContext;
    final List<String> typeList = new ArrayList<>();
    final Map<String, MessageSender> senderMap = new HashMap<>();
    public SenderProcessorByPropInitializer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    @PostConstruct
    public void initMap() {
        for (String senderId : typeList) {
            senderMap.put(senderId, (MessageSender)applicationContext.getBean(senderId));
        }
    }
}
