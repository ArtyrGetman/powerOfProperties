package com.properties.examples.examples.convertors_example.client.convertor_by_dto_sheme;

import com.properties.examples.examples.convertors_example.RestTemplateService;
import com.properties.examples.examples.convertors_example.client.VehicleDtoList;
import com.properties.examples.examples.convertors_example.server.VehicleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class VehicleDtoSchemeConverter {

    private final RestTemplateService restTemplateService;


    public List<VehicleSystemBDto> getData() {
        return systemBDtoListConverter(restTemplateService.getData());
    }

    public List<VehicleSystemBDto> getDataV2() {
        return systemBDtoListConverterV2(restTemplateService.getData());
    }

    private List<VehicleSystemBDto> systemBDtoListConverter(VehicleDtoList vehicleDtoList) {
        List<VehicleSystemBDto> vehicleSystemBDtos = new ArrayList<>();
        for (VehicleDto vehicleDto : vehicleDtoList.getVehicleDtoList()) {
            VehicleSystemBDto vehicleSystemBDto = new VehicleSystemBDto();
            vehicleSystemBDto.setColor(vehicleDto.getColor());
            if ("A".equals(vehicleDto.getType())) {
                vehicleSystemBDto.setType("MOTO");
                vehicleSystemBDtos.add(vehicleSystemBDto);
                continue;
            }
            if ("B".equals(vehicleDto.getType())) {
                vehicleSystemBDto.setType("CAR");
                vehicleSystemBDtos.add(vehicleSystemBDto);
                continue;
            }
        }
        return vehicleSystemBDtos;
    }

    private static final List<String> TYPE_LIST = Arrays.asList("A", "B");

    private List<VehicleSystemBDto> systemBDtoListConverterV2(VehicleDtoList vehicleDtoList) {
        List<VehicleSystemBDto> vehicleSystemBDtos = new ArrayList<>();
        for (VehicleDto vehicleDto : vehicleDtoList.getVehicleDtoList()) {
            VehicleSystemBDto vehicleSystemBDto = new VehicleSystemBDto();
            vehicleSystemBDto.setColor(vehicleDto.getColor());
            if (TYPE_LIST.contains(vehicleDto.getType())) {
                vehicleSystemBDto.setType(Objects.requireNonNull(VehicleTypeConstant.find(vehicleDto.getType())).name());
                vehicleSystemBDtos.add(vehicleSystemBDto);
                continue;
            }
        }
        return vehicleSystemBDtos;
    }


}
