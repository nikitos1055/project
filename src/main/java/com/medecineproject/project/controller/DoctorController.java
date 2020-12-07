package com.medecineproject.project.controller;

import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.service.DoctorService;
import com.medecineproject.project.service.impl.DoctorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DoctorController {
    @Autowired
    private DoctorService serviceDoctors = new DoctorServiceImpl();

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllShops() {
        log.info("Looking for all doctors");
        List<Doctor> shops = serviceDoctors.findAll();
        if (shops.isEmpty()) {
            log.error("No records found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @GetMapping("/doctors/by-category/{category}")
    public ResponseEntity<List<Doctor>> getAllShopsByName(@PathVariable("category") String category) {
        log.info("Looking for all doctors with category : {} ", category);
        List<Doctor> doctorsWithCategory = serviceDoctors.findAllByCategory(category.toUpperCase());
        if (doctorsWithCategory.isEmpty()) {
            log.error("No records found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(doctorsWithCategory, HttpStatus.OK);
    }
}
