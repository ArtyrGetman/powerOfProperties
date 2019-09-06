package com.properties.examples.examples.method_with_default_propertie_value;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class SpecialValidation implements ValidationRule {

    @Value("${start.date:}")
    String date;


    @Override
    public void doValidation(String command) {

    }

    @Override
    public void doValidationV2(List<String> command) {
        doSomeThinkStartingFromDate();
    }


    public void doSomeThinkStartingFromDate() {
        if (!date.isEmpty()) {
            String startDate = date;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dateTime = LocalDate.parse(startDate, formatter);
            //....... do some logic
            System.out.println("date is -> " + dateTime);
        }
        System.out.println("method do checkV2 not running? value is empty or not set");
    }
}
