package com.apkmechanic.drones.repo;

import com.apkmechanic.drones.models.Medicine;

import java.util.List;

/**
 * @author Fraud47
 * @project drones
 * @website www.apkmechanic.co.zw
 */
public interface MedicineRepository {
    List<Medicine> findById(Long id);
}
