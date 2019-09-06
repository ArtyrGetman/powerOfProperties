package com.properties.examples.examples.method_with_default_propertie_value;

import java.util.List;

public interface ValidationRule {
    void doValidation(String command);

    void doValidationV2(List<String> command);
}
