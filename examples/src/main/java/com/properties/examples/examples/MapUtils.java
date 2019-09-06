package com.properties.examples.examples;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Component
@ConfigurationProperties()
public class MapUtils {

    public final Map<String, String> driverDocType2Category = new HashMap<>();
    private final Map<String, List<String>> driverDocType2Categories = new HashMap<>();
    private final Map<String, String> test_bean_map = new HashMap<>();

}
