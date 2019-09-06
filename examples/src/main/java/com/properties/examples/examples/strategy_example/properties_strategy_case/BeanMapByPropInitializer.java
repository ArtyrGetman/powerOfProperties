package com.properties.examples.examples.strategy_example.properties_strategy_case;

import com.properties.examples.examples.strategy_example.BeanInterface;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Getter
@Component
@ConfigurationProperties
public class BeanMapByPropInitializer {

    @Autowired
    private ApplicationContext applicationContext;

    final Map<String, String> test_bean_map = new HashMap<>();
    Map<String, BeanInterface> interfaceMap = new HashMap<>();

    @PostConstruct
    public void initMap() {
        for (Map.Entry<String, String> entry : test_bean_map.entrySet()) {
            Object createdObject = applicationContext.getBean(entry.getValue());
            interfaceMap.put(entry.getKey(), (BeanInterface) createdObject);
        }
    }

}
