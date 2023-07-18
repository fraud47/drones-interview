package com.apkmechanic.drones.services;

import com.apkmechanic.drones.data.MedicineDto;
import com.apkmechanic.drones.data.MedicineRequest;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Fraud47
 * @project drones
 * @website www.apkmechanic.co.zw
 */
public interface MedicineService {
    public String storeFile(MultipartFile file);

    public Resource loadFileAsResource(String fileName);

    public MedicineDto loadMedications(Long droneId, String filePath, MedicineRequest medicineRequest);

    public List<MedicineDto> findLoadedMedicationsByDroneId(Long droneId);
}
