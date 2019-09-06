package com.properties.examples.examples.convertors_example.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private String type;
    private String subType;
    private String weight;
    private String color;
}
