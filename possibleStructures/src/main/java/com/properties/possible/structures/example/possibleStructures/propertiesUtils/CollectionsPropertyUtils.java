package com.properties.possible.structures.example.possibleStructures.propertiesUtils;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Component
@ConfigurationProperties()
public class CollectionsPropertyUtils {
    public final Map<String, String> driverDocType2Category = new HashMap<>();
    private final Map<String, List<String>> driverDocType2Categories = new HashMap<>();
    private final List<String> stringList = new ArrayList<>();
    private final Map<String, String> test_bean_map = new HashMap<>();
}
