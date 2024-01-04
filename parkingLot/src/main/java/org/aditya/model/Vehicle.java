package org.aditya.model;

import org.aditya.enums.VEHICLE_TYPE;

public class Vehicle {
    private int vehicleNo;
    VEHICLE_TYPE vehicleType;

    public int getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(int vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public VEHICLE_TYPE getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VEHICLE_TYPE vehicleType) {
        this.vehicleType = vehicleType;
    }
}
