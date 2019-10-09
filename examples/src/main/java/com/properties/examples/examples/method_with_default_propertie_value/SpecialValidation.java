package com.properties.examples.examples.method_with_default_propertie_value;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Component
public class SpecialValidation implements ValidationRule {

    @Value("${start.date}")
    String date;

    @Override
    public void doValidation() {
        doSomeThinkStartingFromDate();

    }

    public void doSomeThinkStartingFromDate() {
        if (!isMustIgnoreValidation()) {
            doValidationData();
        }
    }

    private boolean isMustIgnoreValidation() {
        if (!date.isEmpty()) {
            String endDate = date;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate limitationFinishDate = LocalDate.parse(endDate, formatter);

            SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date(System.currentTimeMillis());
            String currentDate = formatter2.format(date);
            LocalDate dateNow = LocalDate.parse(currentDate, formatter);

            System.out.println(limitationFinishDate.compareTo(dateNow));

            if (dateNow.compareTo(limitationFinishDate) < 0) {
                System.out.println("do  check");
                return true;
            } else {
                System.out.println("not check");
                return false;
            }

        } else {
            return false;
        }
    }

    public void doValidationData() {
        System.out.println(" I am validate new data from front");
    }
}
