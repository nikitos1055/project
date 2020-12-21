package com.medecineproject.project.controller;

import com.google.gson.Gson;
import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.model.Meeting;
import com.medecineproject.project.model.enums.Status;
import com.medecineproject.project.service.DoctorService;
import com.medecineproject.project.service.MeetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RestController
public class DoctorController {
    @Autowired
    private  DoctorService doctorService;

    @Autowired
    private MeetingService meetingService;

    @GetMapping("/doctors")
    public void getAllDoctors(HttpServletResponse resp) throws IOException {
        List<Doctor> doctors = doctorService.findAll();
        doctors.remove(doctorService.readTop());
        doctors.removeIf(d -> d.getStatus() == Status.BANNED);

        if (doctors.isEmpty()) log.error("No records found");

        String jsonData = new Gson().toJson(doctors);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonData);
    }

    @GetMapping("/doctors/by-category/{category}")
    public void getAllDoctorsByName(@PathVariable String category, HttpServletResponse resp) throws IOException {
        log.info("Looking for all doctors with category : {} ", category);
        List<Doctor> doctorsWithCategory = doctorService.findAllByCategory(category);
        doctorsWithCategory.remove(doctorService.readTop());
        doctorsWithCategory.removeIf(d -> d.getStatus() == Status.BANNED);

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
    public void getTopDoctor(HttpServletResponse resp) throws IOException {
        Doctor doctor = doctorService.readTop();
        if (Objects.isNull(doctor)) {
            log.error("No records found");
        }
        String jsonData = new Gson().toJson(doctor);
        log.info("JSON data : " + jsonData);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonData);
    }

    @GetMapping("/doctors/by-id")
    public Optional<Doctor> getDoctorById(HttpServletRequest req) {
        Integer id = Integer.parseInt(req.getSession().getAttribute("idDoctor").toString());
        log.info(String.valueOf(id));
        return doctorService.findById(id);
    }

    @GetMapping("/doctor/meetings/{id}")
    public void getDoctorMeetings(HttpServletResponse resp, @PathVariable int id) throws IOException {
        List<Meeting> meetings = meetingService.findAll();
        if (meetings.isEmpty()) {
            log.error("No records found");
        }
        List<Meeting> doctorsMeetings = new ArrayList<>();
        for (Meeting m : meetings) {
            if (m.getDoctor().getId() == id) {
                doctorsMeetings.add(m);
            }
        }

        log.info(String.valueOf(doctorsMeetings));
        String jsonData = new Gson().toJson(doctorsMeetings);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonData);
    }

    @PostMapping("/doctor")
    public void getDoctor(HttpServletRequest req) {
        Integer id = Integer.parseInt(req.getParameter("idDoctor"));

        HttpSession session = req.getSession(true);
        session.setAttribute("idDoctor", id);
    }
}
