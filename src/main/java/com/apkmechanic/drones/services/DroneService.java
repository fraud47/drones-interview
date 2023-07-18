package com.apkmechanic.drones.services;

import com.apkmechanic.drones.data.BatteryResponse;
import com.apkmechanic.drones.data.DroneDto;

import java.util.List;

/**
 * @author Fraud47
 * @project drones
 * @website www.apkmechanic.co.zw
 */
public interface DroneService {

    DroneDto registerDrone(DroneDto droneDto);
    List<DroneDto> availableDrones();
    BatteryResponse checkDroneBatteryLevel(Long droneId);

}

