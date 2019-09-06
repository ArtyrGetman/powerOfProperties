package com.properties.examples.examples.method_with_default_propertie_value;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailValidation implements ValidationRule {
    @Override
    public void doValidation(String command) {
        if ("email_on".equals(command)) {
            System.out.println("validate email");
        }
    }

    @Override
    public void doValidationV2(List<String> command) {
        if (command.contains("email_on")){
            System.out.println("validate email");
        }
    }
}
