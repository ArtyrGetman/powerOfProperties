package com.properties.examples.examples.method_with_default_propertie_value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Configuration

public class DoCheck {

    @Value("${start.flag:off}")
    private String turnOnCommand;
    @Value("#{'${start.command.list}'.split(',')}")
    private List<String> turnOnCommandList;
    @Autowired
    private Map<String, ValidationRule> stringValidationRuleMap;

//    @Value("#{systemEnvironment[new java.text.SimpleDateFormat('${start.check.date_format}').parse('${start.check.date}')]?:'#{null}'}")
//    Date myDate;

    @Value("#{new java.text.SimpleDateFormat('${start.check.date_format}').parse('${start.check.date}')}")
    Date myDate;

    @Value("#{'${start.date}' ?: 'def'}")
    String date;

    public void doSomeCheck() {
//        for (Map.Entry<String, ValidationRule> stringValidationRuleEntry : stringValidationRuleMap.entrySet()) {
//            stringValidationRuleEntry.getValue().doValidationV2(turnOnCommandList);
//        }
        System.out.println(date);
    }
}
