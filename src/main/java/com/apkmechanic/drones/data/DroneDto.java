package com.apkmechanic.drones.data;

import com.apkmechanic.drones.models.Model;
import com.apkmechanic.drones.models.State;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author Fraud47
 * @project drones
 * @website www.apkmechanic.co.zw
 */
@Data
public class DroneDto {
    private Long id;
    @Size(min = 2, message = "serial number is too short requires a minimum of atleast 2 characters")
    @Size(max = 100, message = "serial number can not be longer than 100 characters}")
    private String serialNumber;
    private int batteryLevel;
    private Model model;
    private State state;
}
