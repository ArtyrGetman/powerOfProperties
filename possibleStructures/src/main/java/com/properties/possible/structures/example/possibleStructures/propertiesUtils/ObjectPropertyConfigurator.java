package com.properties.possible.structures.example.possibleStructures.propertiesUtils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "driver")
public class ObjectPropertyConfigurator {
    String url;
    String username;
    String password;
}
