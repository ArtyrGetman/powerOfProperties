package com.properties.possible.structures.example.possibleStructures;

import com.properties.possible.structures.example.possibleStructures.propertiesUtils.CollectionsPropertyUtils;
import com.properties.possible.structures.example.possibleStructures.propertiesUtils.ObjectPropertyConfigurator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PropertiesService {

  //  private final ObjectPropertyConfigurator objectPropertyConfigurator;
    private final CollectionsPropertyUtils collectionsPropertyUtils;

    @Value("#{${test.map}}")
    private Map<String, String> testMap2;

    @Value("#{${test.map.list.value}}")
    Map<String, List<String>> testMapListValue2;

    @Value("${number.array}")
    private int [] numberArray;

    @Value("#{'${stringList}'.split(',')}")
    private List<String> stringList2;

    @Value("#{${test.map}.key3}")
    private String fieldFomMap2;

    @Value("#{${test.map}.?[key!='key3']}")
    private Map<String, String> filteredTestMap2;

    void mapFromProperties() {
        Map<String, String> driverDocType2CategoryMap = collectionsPropertyUtils.getDriverDocType2Category();
        driverDocType2CategoryMap.forEach((k, v) -> System.out.println(k + " ->" + v));
    }

    void mapFromPropertiesWithListValues() {
        Map<String, List<String>> driverDocType2CategoriesMap = collectionsPropertyUtils.getDriverDocType2Categories();
        //Todo можем переложить, но зачем?
        //Map<String, List<String>> testPropMapList = new HashMap<>();
        //testPropMap.forEach((k, v) -> testPropMapList.put(k, Arrays.asList(v.split(","))));
        driverDocType2CategoriesMap.forEach((k, v) -> System.out.println(k + " ->" + v));
    }

    void mapFromPropertiesSecondOption() {
        testMap.forEach((k, v) -> System.out.println(k + " ->" + v));
    }

    void mapFromPropertiesWithListValuesSecondOption() {
        testMapListValue.forEach((k, v) -> System.out.println(k + " ->" + v));
    }

  //  void objectFromProperties() {
  //      System.out.println(objectPropertyConfigurator.toString());
  //  }

    void arrayFromPropFile(){
        for (int i=0; i<numberArray.length;i++){
            System.out.println(numberArray[i]);
        }
    }

    void listFromProperties() {
        collectionsPropertyUtils.getStringList().forEach(System.out::println);
    }

    void listFromPropertiesSecondOption() {
        System.out.println(stringList);

    }

    void valueFromMapByField() {
        System.out.println(fieldFomMap);
    }

    void filteredMap() {
        System.out.println(filteredTestMap);
    }


    @Value("#{${test.map}}")
    private Map<String, String> testMap;

    @Value("#{${test.map.list.value}}")
    Map<String, List<String>> testMapListValue;

    @Value("#{'${stringList}'.split(',')}")
    private List<String> stringList;

    @Value("#{${test.map}.key3}")
    private String fieldFomMap;

    @Value("#{${test.map}.?[key!='key3']}")
    private Map<String, String> filteredTestMap;

    @Value("#{new java.text.SimpleDateFormat('${start.check.date_format}').parse('${start.check.date}')}")
    Date myDate;


}
