package com.properties.examples.examples.strategy_example.base_strategy_case;

import com.properties.examples.examples.strategy_example.BeanInterface;
import com.properties.examples.examples.strategy_example.BeanOne;
import com.properties.examples.examples.strategy_example.BeanTwo;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Getter
@Component
public class BeanMapInitializer {

    Map<String, BeanInterface> stringBeanInterfaceMap = new HashMap<>();

    @PostConstruct
    public void init() {
        stringBeanInterfaceMap.put("beanOne", new BeanOne());
        stringBeanInterfaceMap.put("beanTwo", new BeanTwo());
    }
}
