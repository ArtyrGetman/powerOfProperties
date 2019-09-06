package com.properties.examples.examples.convertors_example.client.convertor_by_dto_sheme;

public enum VehicleTypeConstant {
    MOTO("A"),
    CAR("B"),
    TRUCK("C"),
    BUS("D");

    VehicleTypeConstant(String type) {
        this.type = type;
    }
    private final String type;
    public String getType() {
        return type;
    }

    public static VehicleTypeConstant find(String type) {
        for (VehicleTypeConstant vehicleTypeConstant : VehicleTypeConstant.values()) {
            if (vehicleTypeConstant.getType().equalsIgnoreCase(type)) {
                return vehicleTypeConstant;
            }
        }
        return null;
    }
}
