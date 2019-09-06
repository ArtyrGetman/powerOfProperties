package com.properties.examples.examples.convertors_example.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/system_a")
public class AddressDataController {

    @Autowired
    private VehicleDataStorage vehicleDataStorage;

    @GetMapping("/get")
    public List<VehicleDto> getAddresses() {
        return vehicleDataStorage.vehicleDtoList();
    }
}
