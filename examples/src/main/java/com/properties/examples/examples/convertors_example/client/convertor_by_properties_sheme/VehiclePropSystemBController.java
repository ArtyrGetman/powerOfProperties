package com.properties.examples.examples.convertors_example.client.convertor_by_properties_sheme;

import com.properties.examples.examples.convertors_example.client.convertor_by_dto_sheme.VehicleSystemBDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system_b_prop")
@RequiredArgsConstructor
public class VehiclePropSystemBController {

    private final VehiclePropertiesSchemeConverter schemeConverter;

    @GetMapping("/get")
    public List<VehicleSystemBDto> getData() {
        return schemeConverter.getData();
    }
}
