package com.properties.examples.examples.strategy_example;

import org.springframework.stereotype.Component;

@Component
public class BeanTwo implements BeanInterface {
    @Override
    public String doSomeCase() {
       return " bean two work";
    }


}
