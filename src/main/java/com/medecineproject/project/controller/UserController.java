package com.medecineproject.project.controller;

import com.google.gson.Gson;
import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.model.Meeting;
import com.medecineproject.project.model.User;
import com.medecineproject.project.service.DoctorService;
import com.medecineproject.project.service.MeetingService;
import com.medecineproject.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private DoctorService serviceDoctors;

    @Autowired
    private UserService serviceUser;

    @Autowired
    private MeetingService meetingService;

    @PostMapping("/update-user")
    public int updateUser(@RequestBody User user) {
        log.info(String.valueOf(user));
        User getUser = serviceUser.readByLogin(user.getLogin());
        log.info(String.valueOf(getUser));

        getUser.setName(user.getName());
        getUser.setSurname(user.getSurname());
        serviceUser.save(getUser);
        log.info("User {} was updated", user);
        return 200;
    }

    @PostMapping("/update-doctor")
    public int updateDoctor(@RequestBody Doctor doctor) {
        Doctor getDoc = serviceDoctors.readByLogin(doctor.getLogin());
        log.info(String.valueOf(getDoc));

        getDoc.setName(doctor.getName());
        getDoc.setSurname(doctor.getSurname());
        getDoc.setCategory(doctor.getCategory());
        getDoc.setExperience(doctor.getExperience());

        serviceDoctors.save(getDoc);
        log.info("User {} was updated", getDoc);
        return 200;
    }

    @GetMapping("/user/meetings/{id}")
    public void getUserMeetings(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id) throws IOException {
        List<Meeting> meetings = meetingService.findAll();
        if (meetings.isEmpty()) {
            log.error("No records found");
        }
        List<Meeting> userMeetings = new ArrayList<>();
        for (Meeting m : meetings) {
            if (m.getUser().getId() == id) {
                userMeetings.add(m);
            }
        }

        log.info(String.valueOf(userMeetings));
        String jsonData = new Gson().toJson(userMeetings);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonData);
    }

}
