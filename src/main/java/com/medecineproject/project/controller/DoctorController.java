package com.medecineproject.project.controller;

import com.google.gson.Gson;
import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.service.DoctorService;
import com.medecineproject.project.service.impl.DoctorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class DoctorController {
    @Autowired
    private DoctorService serviceDoctors = new DoctorServiceImpl();

    @GetMapping("/doctors")
    public void getAllShops(HttpServletResponse resp) throws IOException {
        List<Doctor> shops = serviceDoctors.findAll();
        if (shops.isEmpty()) {
            log.error("No records found");
        }
        String jsonData = new Gson().toJson(shops);
        log.info(String.valueOf(shops));
        log.info("JSON data : " + jsonData);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonData);
    }

    @GetMapping("/doctors/by-category/{category}")
    public void getAllShopsByName(@PathVariable String category, HttpServletResponse resp) throws IOException {
        log.info("Looking for all doctors with category : {} ", category);
        List<Doctor> doctorsWithCategory = serviceDoctors.findAllByCategory(category);

        if (doctorsWithCategory.isEmpty()) {
            log.error("No records found");
        }
        String jsonData = new Gson().toJson(doctorsWithCategory);
        log.info(String.valueOf(doctorsWithCategory));
        log.info("JSON data : " + jsonData);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonData);
    }

    @GetMapping("/doctors-top")
    public void getTopDoctor(@PathVariable int number, HttpServletResponse resp) throws IOException {
        Doctor doctor = serviceDoctors.readTopByNumOfMeetingsWithPatients(number);
        if (Objects.isNull(number)) {
            log.error("No records found");
        }
        String jsonData = new Gson().toJson(doctor);
        log.info(String.valueOf(doctor));
        log.info("JSON data : " + jsonData);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonData);
    }
}
