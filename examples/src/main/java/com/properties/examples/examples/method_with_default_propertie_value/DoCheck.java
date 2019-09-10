package com.properties.examples.examples.method_with_default_propertie_value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import java.util.Map;

@Configuration
public class DoCheck {

    @Autowired
    private Map<String, ValidationRule> stringValidationRuleMap;

    public void doSomeCheck() {
        for (Map.Entry<String, ValidationRule> stringValidationRuleEntry : stringValidationRuleMap.entrySet()) {
            stringValidationRuleEntry.getValue().doValidation();
        }
    }
}
