package com.properties.examples.examples.convertors_example.client.convertor_by_dto_sheme;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system_b")
@RequiredArgsConstructor
public class VehicleSystemBController {

    private final VehicleDtoSchemeConverter schemeConverter;

    @GetMapping("/get")
    public List<VehicleSystemBDto> getData() {
        return schemeConverter.getData();
    }

    @GetMapping("/get/v2")
    public List<VehicleSystemBDto> getDataV2() {
        return schemeConverter.getDataV2();
    }
}
