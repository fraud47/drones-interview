package com.apkmechanic.drones.services;

import com.apkmechanic.drones.data.BatteryResponse;
import com.apkmechanic.drones.data.DroneDto;
import com.apkmechanic.drones.exception.ResourceNotFoundException;
import com.apkmechanic.drones.models.Drone;
import com.apkmechanic.drones.models.State;
import com.apkmechanic.drones.repo.DroneRepository;
import com.apkmechanic.drones.utils.Constants;
import com.apkmechanic.drones.utils.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fraud47
 * @project drones
 * @website www.apkmechanic.co.zw
 */
@Service
public class DroneServiceImpl implements DroneService{
    private final DroneRepository droneRepository;

    public DroneServiceImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public DroneDto registerDrone(DroneDto droneDto) {
        Drone saveDrone = droneRepository.save(Mappers.mapToDrone(droneDto));
        return Mappers.mapToDroneDto(saveDrone);
    }

    @Override
    public List<DroneDto> availableDrones() {
        // drone has to be idle and battery level above 25
        return droneRepository.findByState(State.IDLE)
                .stream()
                .map(Mappers::mapToDroneDto)
                .filter(drone ->  drone.getBatteryLevel() > Constants.LOW_BATTERY_LEVEL)
                .collect(Collectors.toList());
    }

    @Override
    public BatteryResponse checkDroneBatteryLevel(Long droneId) {
        int batteryLevel = droneRepository.findById(droneId).
                orElseThrow(() -> new ResourceNotFoundException("Drone", "id", droneId)).getBatteryLevel();
        BatteryResponse batteryResponse = new BatteryResponse();
        batteryResponse.setBatteryLevel(String.valueOf(batteryLevel) + "%");
        return  batteryResponse;
    }
}
