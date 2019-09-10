package com.properties.examples.examples.method_with_default_propertie_value;

import org.springframework.stereotype.Component;

@Component
public class EmailValidation implements ValidationRule {
    @Override
    public void doValidation() {
        System.out.println("validate email");
    }
}
