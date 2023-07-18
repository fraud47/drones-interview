package com.apkmechanic.drones.utils;

import com.apkmechanic.drones.data.DroneDto;
import com.apkmechanic.drones.data.MedicineDto;
import com.apkmechanic.drones.models.Drone;
import com.apkmechanic.drones.models.Medicine;

/**
 * @author Fraud47
 * @project drones
 * @website www.apkmechanic.co.zw
 */

public class Mappers {
    public static Drone mapToDrone(DroneDto droneDto){
        Drone drone = new Drone();
        drone.setId(droneDto.getId());
        drone.setSerialNumber(droneDto.getSerialNumber());
        drone.setBatteryLevel(droneDto.getBatteryLevel());
        drone.setState(droneDto.getState());
        drone.setModel(droneDto.getModel());
        return  drone;

    }

    public static DroneDto mapToDroneDto(Drone drone){
        DroneDto droneDto = new DroneDto();
        droneDto.setId(drone.getId());
        droneDto.setSerialNumber(drone.getSerialNumber());
        droneDto.setBatteryLevel(drone.getBatteryLevel());
        droneDto.setState(drone.getState());
        droneDto.setModel(drone.getModel());
        return  droneDto;
    }

    public static MedicineDto mapToDto(Medicine medicine){
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setDroneId(medicine.getDrone().getId());
        medicineDto.setImage(medicine.getImage());
        medicineDto.setName(medicine.getName());
        medicineDto.setCode(medicine.getCode());
        medicineDto.setWeight(medicine.getWeight());
        medicineDto.setId(medicine.getId());
        return medicineDto;
    }
}
