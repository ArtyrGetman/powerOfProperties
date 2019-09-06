package com.properties.examples.examples;

import com.properties.examples.examples.method_with_default_propertie_value.DoCheck;
import com.properties.examples.examples.strategy_example.BeanInterface;
import com.properties.examples.examples.strategy_example.base_strategy_case.BeanMapInitializer;
import com.properties.examples.examples.strategy_example.properties_strategy_case.BeanMapByPropInitializer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
@RequiredArgsConstructor
public class ExamplesApplication implements CommandLineRunner {

    private final DoCheck doCheck;
    private final BeanMapInitializer beanMapInitializer;
    private final BeanMapByPropInitializer beanMapByPropInitializer;
    @Autowired
    private Map<String, BeanInterface> stringBeanInterfaceMap;

    public static void main(String[] args) {
        SpringApplication.run(ExamplesApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println(" Case 1");
        for (Map.Entry<String, BeanInterface> entry : beanMapInitializer.getStringBeanInterfaceMap().entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue().doSomeCase());
        }

        System.out.println("\n Case 2");
        for (Map.Entry<String, BeanInterface> entry : stringBeanInterfaceMap.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue().doSomeCase());
        }

        System.out.println("\n Case 3. GET BEANS FROM PROPERTIES FILE");
        for (Map.Entry<String, BeanInterface> entry : beanMapByPropInitializer.getInterfaceMap().entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue().doSomeCase());
        }

        System.out.println("\n Default value Example");
        doCheck.doSomeCheck();

        System.out.println("\n execute method starting from date");
        doCheck.doSomeCheck();
    }
}
