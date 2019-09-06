package com.properties.possible.structures.example.possibleStructures;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class PossibleStructuresApplication implements CommandLineRunner {

    private final PropertiesService propertiesService;

    public static void main(String[] args) {
        SpringApplication.run(PossibleStructuresApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Map output example with structure Map<String,String>  :");
        propertiesService.mapFromProperties();

        System.out.println("\nMap output example with structure Map<String,List<String>>  :");
        propertiesService.mapFromPropertiesWithListValues();

        System.out.println("\nMap output second option example with structure Map<String,String>  :");
        propertiesService.mapFromPropertiesSecondOption();

        System.out.println("\nMap output second option example with structure Map<String,List<String>>  :");
        propertiesService.mapFromPropertiesWithListValuesSecondOption();

        System.out.println("\n field from map :");
        propertiesService.valueFromMapByField();

        System.out.println("\n filtered map:");
        propertiesService.filteredMap();

        System.out.println("\n array output example");
        propertiesService.arrayFromPropFile();

        System.out.println("\n List output example");
        propertiesService.listFromProperties();
        System.out.println("\nList output example second option");
        propertiesService.listFromPropertiesSecondOption();

        System.out.println("\n Object output example :");
      //  propertiesService.objectFromProperties();
    }
}
