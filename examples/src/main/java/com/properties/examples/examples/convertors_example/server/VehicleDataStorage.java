package com.properties.examples.examples.convertors_example.server;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleDataStorage {

    public List<VehicleDto> vehicleDtoList() {
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        vehicleDtoList.add(new VehicleDto("A", "", "10", "red"));
        vehicleDtoList.add(new VehicleDto("A", "", "11", "blue"));
        vehicleDtoList.add(new VehicleDto("B", "", "20", "black"));
        vehicleDtoList.add(new VehicleDto("C", "", "30", "gray"));
        vehicleDtoList.add(new VehicleDto("D", "", "40", "pink"));

        vehicleDtoList.add(new VehicleDto("A1", "", "40", "pink"));
        vehicleDtoList.add(new VehicleDto("A2", "", "40", "pink"));
        vehicleDtoList.add(new VehicleDto("B3", "", "40", "pink"));
        return vehicleDtoList;
    }
}
