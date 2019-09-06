package com.properties.examples.examples.convertors_example.client;

import com.properties.examples.examples.convertors_example.server.VehicleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDtoList {
    private List<VehicleDto> vehicleDtoList;
}
