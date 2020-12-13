package com.medecineproject.project.controller;

import com.google.gson.Gson;
import com.medecineproject.project.model.Doctor;
import com.medecineproject.project.model.LoginData;
import com.medecineproject.project.model.User;
import com.medecineproject.project.model.enums.Status;
import com.medecineproject.project.service.DoctorService;
import com.medecineproject.project.service.MeetingService;
import com.medecineproject.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class AdminController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public void getAllDoctors(HttpServletResponse resp) throws IOException {
        List<Doctor> doctors = doctorService.findAll();
        List<User> users = userService.findAll();
        List<LoginData> allUsers = new ArrayList<>();
        allUsers.addAll(doctors);
        allUsers.addAll(users);

        if (doctors.isEmpty()) log.error("No records found");

        String jsonData = new Gson().toJson(allUsers);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonData);
    }

    @PostMapping("/ban-user/{id}")
    public void banUser(@PathVariable int id) throws IOException {
        if (!Objects.isNull(userService.readById(id))) {
            User user = userService.readById(id);
            user.setStatus(Status.BANNED);
            userService.update(user);

        } else if (!Objects.isNull(doctorService.readById(id))) {
            Doctor doctor = doctorService.readById(id);
            doctor.setStatus(Status.BANNED);
            doctorService.update(doctor);
        }
    }

    @PostMapping("/unban-user/{id}")
    public void unbanUser(@PathVariable int id) throws IOException {
        if (!Objects.isNull(userService.readById(id))) {
            User user = userService.readById(id);
            user.setStatus(Status.ACTIVE);
            userService.update(user);

        } else if (!Objects.isNull(doctorService.readById(id))) {
            Doctor doctor = doctorService.readById(id);
            doctor.setStatus(Status.ACTIVE);
            doctorService.update(doctor);
        }
    }

}
