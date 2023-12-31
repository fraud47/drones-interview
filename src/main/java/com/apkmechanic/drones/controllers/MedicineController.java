package com.apkmechanic.drones.controllers;

import com.apkmechanic.drones.data.MedicineDto;
import com.apkmechanic.drones.data.MedicineRequest;
import com.apkmechanic.drones.services.MedicineService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author Fraud47
 * @project drones
 * @website www.apkmechanic.co.zw
 */

public class MedicineController {

    Logger logger = LoggerFactory.getLogger(MedicineController.class);
    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/load-drone/{droneId}")
    public ResponseEntity<MedicineDto> uploadFile(@Valid @RequestParam("image") MultipartFile image,
                                                  @PathVariable Long droneId,
                                                  @RequestParam  String name,
                                                  @RequestParam  String code,
                                                  @RequestParam float weight) {
        logger.info(name + " weight is "+ weight);
        String fileName = medicineService.storeFile(image);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/medicines")
                .path("/download-image/")
                .path(fileName)
                .toUriString();
        MedicineDto medicine = medicineService.loadMedications(droneId,fileDownloadUri, new MedicineRequest(name,code,weight));
        return new ResponseEntity<>(medicine, HttpStatus.CREATED);
    }

    @GetMapping("/download-image/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = medicineService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.out.print("Could not determine file type.");
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    @GetMapping("find-loaded-drone-items/{droneId}")
    public ResponseEntity<List<MedicineDto>> findLoadedMedicationsByDroneId(@PathVariable Long droneId){
        return ResponseEntity.ok(medicineService.findLoadedMedicationsByDroneId(droneId));
    }
}
