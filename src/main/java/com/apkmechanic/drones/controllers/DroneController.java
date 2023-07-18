package com.apkmechanic.drones.controllers;

import com.apkmechanic.drones.data.BatteryResponse;
import com.apkmechanic.drones.data.DroneDto;
import com.apkmechanic.drones.services.DroneService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fraud47
 * @project drones
 * @website www.apkmechanic.co.zw
 */
@RestController
@RequestMapping("/api/v1/drones")
public class DroneController {

    private final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @PostMapping
    public ResponseEntity<DroneDto> registerDrone(@Valid @RequestBody DroneDto droneDto){
        return new ResponseEntity<>(droneService.registerDrone(droneDto), HttpStatus.CREATED);
    }
    @GetMapping("/available-drones")
    public ResponseEntity<List<DroneDto>> availableDrones(){
        return ResponseEntity.ok(droneService.availableDrones());
    }
    @GetMapping("/check-battery-levels/{droneId}")
    public ResponseEntity<BatteryResponse> checkDroneBatteryLevel(@PathVariable Long droneId){
        return ResponseEntity.ok(droneService.checkDroneBatteryLevel(droneId));
    }
}
