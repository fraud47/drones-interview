package com.apkmechanic.drones.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fraud47
 * @project drones
 * @website www.apkmechanic.co.zw
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineRequest {
    private String name;
    private String code;
    private float weight;

}
