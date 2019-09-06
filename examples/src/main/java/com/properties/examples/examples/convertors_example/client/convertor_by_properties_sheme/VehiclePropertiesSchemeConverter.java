package com.properties.examples.examples.convertors_example.client.convertor_by_properties_sheme;

import com.properties.examples.examples.MapUtils;
import com.properties.examples.examples.convertors_example.RestTemplateService;
import com.properties.examples.examples.convertors_example.client.VehicleDtoList;
import com.properties.examples.examples.convertors_example.client.convertor_by_dto_sheme.VehicleSystemBDto;
import com.properties.examples.examples.convertors_example.server.VehicleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class VehiclePropertiesSchemeConverter {

    private final MapUtils mapUtils;
    private final RestTemplateService restTemplateService;

    public List<VehicleSystemBDto> getData() {
        return systemBDtoListConverterV2(restTemplateService.getData());
    }

    private List<VehicleSystemBDto> systemBDtoListConverter(VehicleDtoList vehicleDtoList) {
        List<VehicleSystemBDto> vehicleSystemBDtos = new ArrayList<>();
        for (Map.Entry<String, String> entry : mapUtils.driverDocType2Category.entrySet()) {
            for (VehicleDto vehicle : vehicleDtoList.getVehicleDtoList()) {
                if (entry.getValue().equals(vehicle.getType())) {
                    VehicleSystemBDto vehicleSystemBDto = initVehicleSystemBDto(entry.getKey(), vehicle);
                    vehicleSystemBDtos.add(vehicleSystemBDto);
                }
            }
        }
        return vehicleSystemBDtos;
    }

    private List<VehicleSystemBDto> systemBDtoListConverterV2(VehicleDtoList vehicleDtoList) {
        List<VehicleSystemBDto> vehicleSystemBDtos = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : mapUtils.getDriverDocType2Categories().entrySet()) {
            for (VehicleDto vehicle : vehicleDtoList.getVehicleDtoList()) {
                if (entry.getValue().contains(vehicle.getType())) {
                    VehicleSystemBDto vehicleSystemBDto = initVehicleSystemBDto(entry.getKey(), vehicle);
                    vehicleSystemBDtos.add(vehicleSystemBDto);
                }
            }
        }
        return vehicleSystemBDtos;
    }

    private VehicleSystemBDto initVehicleSystemBDto(String key, VehicleDto vehicle) {
        VehicleSystemBDto vehicleSystemBDto = new VehicleSystemBDto();
        vehicleSystemBDto.setColor(vehicle.getColor());
        vehicleSystemBDto.setType(key);
        return vehicleSystemBDto;
    }

}
