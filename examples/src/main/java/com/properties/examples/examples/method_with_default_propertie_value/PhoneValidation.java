package com.properties.examples.examples.method_with_default_propertie_value;

import org.springframework.stereotype.Component;



@Component
public class PhoneValidation implements ValidationRule {
    @Override
    public void doValidation() {
        System.out.println("validate phone");
    }


}
